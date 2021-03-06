import { Component, OnInit } from '@angular/core';
import { NgxGalleryAnimation, NgxGalleryImage, NgxGalleryOptions } from 'ngx-gallery';

import { DataExchangeService } from '../../service/data-exchange.service';
import { Product } from '../../model/product';
import { Image } from '../../model/image';


interface ProductSpecs {
  spec: string,
  value: string
}

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  // Setting of the ngx-gallery
  galleryOptions: NgxGalleryOptions[];

  // Images displayed in the ngx-gallery
  galleryImages: NgxGalleryImage[];

  // The selected product
  product: Product;

  // The specifications of the product
  specifications: ProductSpecs[];

  readonly minProductQuantity: number = 1;
  readonly maxProductQuantity: number = 10;

  // The quantity of the chosen product
  productQuantity: number;

  constructor(private dataExchangeService: DataExchangeService) {
    this.product = this.dataExchangeService.selectedProduct;
    this.galleryImages = [];
    this.productQuantity = this.minProductQuantity;
  }

  ngOnInit(): void {
    this.setupGallery();
    this.setupGalleryImages();
    this.parseProductSpecification();
  }

  increaseQuantity(): void {
    if (this.productQuantity < this.maxProductQuantity) {
      this.productQuantity++;
    }
  }

  decreaseQuantity(): void {
    if (this.productQuantity > this.minProductQuantity) {
      this.productQuantity--;
    }
  }

  private setupGallery() {
    this.galleryOptions = [
      {
        width: '400px',
        imageArrowsAutoHide: true,
        imageAutoPlay: true,
        imageAnimation: NgxGalleryAnimation.Slide,
        thumbnailsArrowsAutoHide: true,
        thumbnailsColumns: this.thumbnailsColumns,
        previewFullscreen: true,
        previewCloseOnClick: true,
        previewCloseOnEsc: true,
        previewKeyboardNavigation: true,
        previewZoom: true,
        previewAutoPlayInterval: 4000,  // Apparently this property is not working
        previewInfinityMove: true,
        arrowNextIcon: 'fa fa-arrow-right',
        arrowPrevIcon: 'fa fa-arrow-left'
      }
    ];
  }

  private setupGalleryImages() {
    // Maps each image of the product to the NgxGalleryImage type,
    // and add it to the "galleryImages" array.
    this.product.images.forEach((image: Image) => {
      this.galleryImages.push({
        small: image.smallSizeImage,
        medium: image.mediumSizeImage,
        big: image.largeSizeImage
      });
    });
  }

  private parseProductSpecification() {
    // The specifications of the product are returned as string,
    // on the following pattern:
    // "spec: value, spec: value, spec: value, ..."

    this.specifications = this.product.specifications
    // Split the string in the comma character, this results in a array
    // in the following format: ["spec: value", "spec: value", ...].
      .split(',')

      // Convert each element in a instance of the "ProductSpecs" interface
      .map((spec: string) => {
        const parsedSpec: string[] = spec

        // Split the spec on the colon character, resulting in a array
        // in the following format: ["spec", "value"].
          .split(':')

          // Remove any empty space on the beginning or ending of "spec" and "value"
          .map((spec: string) => spec.trim());

        // Return an instance of the "ProductSpecs" interface
        return { spec: parsedSpec[0], value: parsedSpec[1] };
      });
  }

  /**
   * Return the number of columns to use in the gallery.
   * The number maximum of columns is four.
   */
  private get thumbnailsColumns(): number {
    const numberOfImages: number = this.product.images.length;
    return numberOfImages > 4 ? 4 : numberOfImages;
  }
}
