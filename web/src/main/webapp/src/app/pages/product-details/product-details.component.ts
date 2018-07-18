import { Component, OnInit } from '@angular/core';
import { NgxGalleryAnimation, NgxGalleryImage, NgxGalleryOptions } from 'ngx-gallery';

import { DataExchangeService } from '../../service/data-exchange.service';
import { Product } from '../../model/product';


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

  constructor(private dataExchangeService: DataExchangeService) {
    this.product = this.dataExchangeService.selectedProduct;
  }

  ngOnInit(): void {
    this.setupGallery();
    this.setupGalleryImages();
    this.parseProductSpecification();
  }

  private setupGallery() {
    this.galleryOptions = [
      {
        width: '400px',
        imageArrowsAutoHide: true,
        imageAutoPlay: true,
        imageAnimation: NgxGalleryAnimation.Slide,
        thumbnailsArrowsAutoHide: true,
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
    // TODO: replace with images of the product
    this.galleryImages = [
      {
        small: 'https://images5.alphacoders.com/633/633362.jpg',
        medium: 'https://images5.alphacoders.com/633/633362.jpg',
        big: 'https://images5.alphacoders.com/633/633362.jpg'
      },
      {
        small: 'https://images.alphacoders.com/157/157333.jpg',
        medium: 'https://images.alphacoders.com/157/157333.jpg',
        big: 'https://images.alphacoders.com/157/157333.jpg'
      },
      {
        small: 'https://images.alphacoders.com/223/223421.jpg',
        medium: 'https://images.alphacoders.com/223/223421.jpg',
        big: 'https://images.alphacoders.com/223/223421.jpg'
      },
      {
        small: 'https://images5.alphacoders.com/322/322185.jpg',
        medium: 'https://images5.alphacoders.com/322/322185.jpg',
        big: 'https://images5.alphacoders.com/322/322185.jpg'
      },
      {
        small: 'https://images6.alphacoders.com/412/412813.jpg',
        medium: 'https://images6.alphacoders.com/412/412813.jpg',
        big: 'https://images6.alphacoders.com/412/412813.jpg'
      }
    ];
  }

  private parseProductSpecification() {
    // TODO: parse the specification of the product
    this.specifications = [];
  }
}
