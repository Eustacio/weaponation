# -*- coding: utf-8 -*-

import scrapy
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
        pass
