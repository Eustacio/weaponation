import { Component, Input } from '@angular/core';

import { Product } from './product';

@Component({
  selector: 'app-showcase',
  templateUrl: './showcase.component.html',
  styleUrls: ['./showcase.component.css']
})
export class ShowcaseComponent {

  // Number of maximum page links to display (the little dots above the image)
  readonly pageLinks = 3;

  // If the carousel will play automatically
  @Input() circular: boolean = true;

  // Time between the image change (in milliseconds)
  @Input() autoPlayInterval: number = 4000;

  // The images that are displayed
  @Input() products: Product[];

}
