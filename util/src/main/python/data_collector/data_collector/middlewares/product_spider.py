# -*- coding: utf-8 -*-

from abc import ABC, abstractmethod
from typing import List

from scrapy.http import Response


class ProductSpider(ABC):

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
