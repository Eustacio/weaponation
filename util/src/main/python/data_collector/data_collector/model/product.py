# -*- coding: utf-8 -*-

from decimal import Decimal
from typing import List

import scrapy


class Product(scrapy.Item):
    """
    Model for represent our scraped products
    See: https://doc.scrapy.org/en/latest/topics/items.html
    """
    name: str = scrapy.Field()
    manufacturer: str = scrapy.Field()
    description: str = scrapy.Field()
    specifications: str = scrapy.Field()
    price: Decimal = scrapy.Field()
    category: List[str] = scrapy.Field()
    images: List[str] = scrapy.Field()
