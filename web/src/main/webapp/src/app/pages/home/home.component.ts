import { Component } from '@angular/core';

import { Product } from '../../shared/showcase/product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


  // TODO: fetch all this information from the service
  handguns: Product[] = [
    { name: 'p1', description: 'description 1', price: '$1234.1', imageName: '1911.jpg' },
    { name: 'p2', description: 'description 2', price: '$1234.1', imageName: '1911.jpg' },
    { name: 'p3', description: 'description 3', price: '$1234.1', imageName: '1911.jpg' },
    { name: 'p1', description: 'description 1', price: '$1234.1', imageName: '1911.jpg' },
    { name: 'p2', description: 'description 2', price: '$1234.1', imageName: '1911.jpg' },
    { name: 'p3', description: 'description 3', price: '$1234.1', imageName: '1911.jpg' },
    { name: 'p1', description: 'description 1', price: '$1234.1', imageName: '1911.jpg' },
    { name: 'p2', description: 'description 2', price: '$1234.1', imageName: '1911.jpg' },
    { name: 'p3', description: 'description 3', price: '$1234.1', imageName: '1911.jpg' }
  ];

  shotguns: Product[] = [
    { name: 'p1', description: 'description 1', price: '$1234.1', imageName: 'granede_launcher.jpg' },
    { name: 'p2', description: 'description 2', price: '$1234.1', imageName: 'granede_launcher.jpg' },
    { name: 'p3', description: 'description 3', price: '$1234.1', imageName: 'granede_launcher.jpg' },
    { name: 'p1', description: 'description 1', price: '$1234.1', imageName: 'granede_launcher.jpg' },
    { name: 'p2', description: 'description 2', price: '$1234.1', imageName: 'granede_launcher.jpg' },
    { name: 'p3', description: 'description 3', price: '$1234.1', imageName: 'granede_launcher.jpg' },
    { name: 'p1', description: 'description 1', price: '$1234.1', imageName: 'granede_launcher.jpg' },
    { name: 'p2', description: 'description 2', price: '$1234.1', imageName: 'granede_launcher.jpg' },
    { name: 'p3', description: 'description 3', price: '$1234.1', imageName: 'granede_launcher.jpg' }
  ];

  rifles: Product[] = [
    { name: 'p1', description: 'description 1', price: '$1234.1', imageName: 'ar15_tactical.jpg' },
    { name: 'p2', description: 'description 2', price: '$1234.1', imageName: 'ak47.jpg' },
    { name: 'p3', description: 'description 3', price: '$1234.1', imageName: 'ak47.jpg' },
    { name: 'p1', description: 'description 1', price: '$1234.1', imageName: 'ar15_tactical.jpg' },
    { name: 'p2', description: 'description 2', price: '$1234.1', imageName: 'ak47.jpg' },
    { name: 'p3', description: 'description 3', price: '$1234.1', imageName: 'ak47.jpg' },
    { name: 'p1', description: 'description 1', price: '$1234.1', imageName: 'ar15_tactical.jpg' },
    { name: 'p2', description: 'description 2', price: '$1234.1', imageName: 'ak47.jpg' },
    { name: 'p3', description: 'description 3', price: '$1234.1', imageName: 'ak47.jpg' }
  ];
}
