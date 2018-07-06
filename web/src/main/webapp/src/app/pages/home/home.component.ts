import { Component } from '@angular/core';

import { Product } from '../../model/product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


  // TODO: fetch all this information from the service
  handguns: Product[] = [
    {
      id: 1, name: 'Product 1', description: 'product 1', specifications: '', price: 123,
      categories: [{ id: 1, name: 'category 1' }], manufacturer: { id: 1, name: 'ACME' }
    }
  ];

  shotguns: Product[] = this.handguns;

  rifles: Product[] = this.handguns;
}
