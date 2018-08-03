# -*- coding: utf-8 -*-
from typing import List

import scrapy
from scrapy import Selector
from scrapy.http import TextResponse, Request

from data_collector.middlewares.product_spider import ProductSpider
from data_collector.model.product import Product


class RKGunsSpider(ProductSpider, scrapy.Spider):
    """
    Spider subclass destined to crawl and scrap items from the
    https://www.rkguns.com/ website
    """

    # The name for this spider. This attribute is required by the Scrapy
    name = 'rkguns'

    # The domains that this spider is allowed to crawl
    allowed_domains = ['rkguns.com']

    # A list of URLs where the spider will begin to crawl from
    start_urls = ['https://www.rkguns.com/handguns.html?limit=24']

    category: List[str]

    def parse(self, response: TextResponse) -> [Request, Product]:
        """
        This is the default callback used by Scrapy to process downloaded responses, when their
        requests don’t specify a callback. parse method is in charge of processing the
        response and returning scraped data and/or more URLs to follow.

        :param response: the response to parse
        :returns Request or an instance of Product
       """
        # Checks if we are on the product list page
        if response.url.startswith('https://www.rkguns.com/handguns'):
            # Extracts the category of this product page
            self._extract_category(response)

            # Select the link of the details page for all products on the page
            info_pages: List[Selector] = response.css(".product-name a::attr(href)")

            # Check if the page contains some link
            if info_pages is not None:
                # Creates an Request object for every link found, to be transformed in
                # an Product instance on the "else" statement below.
                for page in info_pages:
                    yield Request(page.extract())

        # We are in the product info page, therefore we already can extract the information
        else:
            yield super().get_product(response)

    def _extract_category(self, response: TextResponse) -> None:
        self.category = response.xpath('//div[contains(@class, "breadcrumbs")]'
                                       '/ul/li/*[self::a or self::strong]//text()').extract()

    def _extract_name(self, response: TextResponse) -> str:
        return response.css('.product-name h1::text').extract_first()

    def _extract_manufacturer(self, response: TextResponse) -> str:
        return response \
            .xpath('//th[contains(text(), "Brand")]/following-sibling::td/text()') \
            .extract_first()

    def _extract_description(self, response: TextResponse) -> str:
        return response.css('.std p::text').extract_first()

    def _extract_price(self, response: TextResponse) -> str:
        return response.css('.regular-price span::text').extract_first(default='$')[1:]

    def _extract_images(self, response: TextResponse) -> List[dict]:
        image_urls: List[str] = response.xpath('//a[contains(@class, "cloud-zoom-gallery")]'
                                               '/@href').extract()

        parsed_urls: List[dict] = []

        for url in image_urls:
            small_image: str = url.replace('800x800', '308x308')
            parsed_urls.append({'large_image': url, 'small_image': small_image})

        return parsed_urls

    def _extract_specifications(self, response: TextResponse) -> List[dict]:
        table_rows = response.xpath('//table[contains(@class, "data-table")]/tbody/tr')
        data: List[dict] = []

        for row in table_rows:
            prop: str = row.xpath('th/text()').extract_first()

            if prop == 'Price':
                value: str = row.xpath('td/span/span/text()').extract_first()
            else:
                value: str = row.xpath('td/text()').extract_first()

            data.append({prop: value})

        return data
