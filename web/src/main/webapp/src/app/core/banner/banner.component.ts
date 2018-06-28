import { Component, OnInit } from '@angular/core';

import { BannerImage } from './banner-image';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {

  // Number of visible images at same time
  readonly visibleImages = 1;

  // Time between the image change (in milliseconds)
  readonly autoplayInterval = 4000;

  // The images of the banner
  bannerImages: BannerImage[];

  ngOnInit(): void {
    // TODO: fetch from database
    this.bannerImages = [
      { imageName: '1911.jpg' },
      { imageName: 'ak47.jpg' },
      { imageName: 'ar15_tactical.jpg' },
      { imageName: 'five_seven.jpg' },
      { imageName: 'granede_launcher.jpg' }
    ];
  }

  /**
   * @return Number of maximum page links to display (the little dots above the image).
   * If total page count exceeds this value a dropdown is displayed instead.
   * */
  get maxPageLinks(): number {
    return this.bannerImages.length;
  }
}
