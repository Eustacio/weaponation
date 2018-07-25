import { Entity } from './entity';

export interface Image extends Entity {
  smallSizeImage: string,
  mediumSizeImage: string,
  largeSizeImage: string
}
