# -*- coding: utf-8 -*-
from scrapy import signals
from scrapy.crawler import Crawler

from data_collector.model.product import Product


class SqlConverterMiddleware:

    def __init__(self, output_sql: bool = False) -> None:
        self.output_sql: bool = output_sql

    @classmethod
    def from_crawler(cls, crawler: Crawler):
        # Connect to the Scrapy "item_scraped" signal, to receive
        # the scraped item from the spider.
        crawler.signals.connect(signal=signals.item_scraped, receiver=cls._item_scraped)

        return cls(crawler.settings.getbool('OUTPUT_SQL'))

    @staticmethod
    def _item_scraped(item: Product):
        pass
