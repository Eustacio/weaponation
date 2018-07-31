# -*- coding: utf-8 -*-
from typing import List

import scrapy
from scrapy import Selector
from scrapy.http import TextResponse, Request

from data_collector.model.product import Product


class RKGunsSpider(scrapy.Spider):
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
            return Product(name=self._extract_name(response),
                           manufacturer=self._extract_manufacturer(response),
                           description=self._extract_description(response),
                           price=self._extract_price(response))

    @staticmethod
    def _extract_name(response: TextResponse) -> str:
        return response.css('.product-name h1::text').extract_first()

    @staticmethod
    def _extract_manufacturer(response: TextResponse) -> str:
        return response \
            .xpath('//th[contains(text(), "Brand")]/following-sibling::td/text()') \
            .extract_first()

    @staticmethod
    def _extract_description(response: TextResponse) -> str:
        return response.css('.std p::text').extract_first()

    @staticmethod
    def _extract_price(response: TextResponse) -> str:
        return response.css('.regular-price span::text').extract_first(default='$')[1:]
