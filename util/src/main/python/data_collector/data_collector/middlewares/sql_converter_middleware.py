# -*- coding: utf-8 -*-

from scrapy.crawler import Crawler


class SqlConverterMiddleware:

    def __init__(self, output_sql: bool = False) -> None:
        self.output_sql: bool = output_sql

    @classmethod
    def from_crawler(cls, crawler: Crawler):
        settings = crawler.settings
        return cls(settings.getbool('OUTPUT_SQL'))
