# -*- coding: utf-8 -*-

from scrapy.crawler import Crawler


class SqlConverterMiddleware:

    def __init__(self, output_sql: bool = False) -> None:
        self.output_sql: bool = output_sql

    @classmethod
    def from_crawler(cls, crawler: Crawler):
        return cls(crawler.settings.getbool('OUTPUT_SQL'))
