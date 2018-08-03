# -*- coding: utf-8 -*-

from abc import ABC, abstractmethod
from typing import List

from scrapy.http import Response

from data_collector.model.product import Product


class ProductSpider(ABC):

    def get_product(self, response: Response) -> Product:
        return Product(name=self._extract_name(response),
                       manufacturer=self._extract_manufacturer(response),
                       description=self._extract_description(response),
                       specifications=self._extract_specifications(response),
                       price=self._extract_price(response),
                       category=self._extract_category(response),
                       images=self._extract_images(response))

    @abstractmethod
    def _extract_name(self, response: Response) -> str:
        pass

    @abstractmethod
    def _extract_manufacturer(self, response: Response) -> str:
        pass

    @abstractmethod
    def _extract_description(self, response: Response) -> str:
        pass

    @abstractmethod
    def _extract_specifications(self, response: Response) -> List[dict]:
        pass

    @abstractmethod
    def _extract_price(self, response: Response) -> str:
        pass

    @abstractmethod
    def _extract_category(self, response: Response) -> List[str]:
        pass

    @abstractmethod
    def _extract_images(self, response: Response) -> List[dict]:
        pass
