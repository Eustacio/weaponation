import { Entity } from './entity';
import { Category } from './category';
import { Image } from './image';
import { Manufacturer } from './manufacturer';

export interface Product extends Entity {
  name: string,
  description: string,
  specifications: string,
  price: number,
  categories: Category[],
  images: Image[],
  manufacturer: Manufacturer
}
