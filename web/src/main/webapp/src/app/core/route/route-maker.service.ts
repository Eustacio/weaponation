import { Injectable } from '@angular/core';
import { Product } from '../../model/product';

interface UrlPath {
  weight: number,
  path: string
}

@Injectable({
  providedIn: 'root'
})
export class RouteMakerService {

  private urls: UrlPath[] = [
    { weight: 1, path: 'firearms' },
    { weight: 2, path: 'handguns' },
    { weight: 2, path: 'shotguns' },
    { weight: 2, path: 'rifles' },
    { weight: 3, path: 'revolvers' },
    { weight: 3, path: 'semi-automatic' },
    { weight: 3, path: 'automatic' },
    { weight: 3, path: 'pump action' },
    { weight: 3, path: 'lever action' },
    { weight: 3, path: 'single shot' },
    { weight: 3, path: 'bolt action' },

    { weight: 1, path: 'ammo' },
    { weight: 2, path: 'bulk ammo' },
    { weight: 2, path: 'blanks' },

    { weight: 1, path: 'optics' },
    { weight: 2, path: 'binoculars' },
    { weight: 2, path: 'flashlights' },
    { weight: 2, path: 'night vision' },
    { weight: 2, path: 'rangefinder' },
    { weight: 2, path: 'scope mounts' },
    { weight: 2, path: 'scopes' },
    { weight: 2, path: 'lasers' },
    { weight: 2, path: 'sights' },
    { weight: 2, path: 'spotting scopes' },
    { weight: 2, path: 'thermal optics' },

    { weight: 1, path: 'knives' },
    { weight: 2, path: 'fixed blade' },
    { weight: 2, path: 'folding blade' },
    { weight: 2, path: 'accessories' },
    { weight: 2, path: 'utility' },

    { weight: 1, path: 'suppressors' }
  ];

  /**
   * Build the route from the product category
   */
  productDetailsRoute(product: Product): string {
    let paths: UrlPath[] = [];

    // Extract the name of all categories
    const categories: string[] = product.categories.map(category => category.name.toLowerCase());

    // Find the correspondent UrlPath for each category
    categories.forEach((category: string) => {
      let foundUrlPath: UrlPath = this.urls.find((url: UrlPath) => url.path == category);
      if (foundUrlPath) {
        // Replace any empty space of the path by "-"
        foundUrlPath.path = foundUrlPath.path.replace(/\s/g, '-');
        paths.push(foundUrlPath);
      }
    });

    // Sort the UrlPath's by using the 'weight' property in ascending order
    paths.sort((path1: UrlPath, path2: UrlPath) => path1.weight - path2.weight);

    // Join the all paths with the "/" character
    let sanitizedPath: string = paths.map((url: UrlPath) => url.path).join('/');

    // Add the product name at the end of the path
    sanitizedPath += '/' + this.sanitizeProductName(product.name);

    return sanitizedPath;
  }

  private sanitizeProductName(productName: string): string {
    return productName
      .replace(/\s/g, '_')  // Replace all empty spaces by underscore
      .replace(/\W/g, '')   // Remove any character that is not [0-9a-zA-Z_] from the product name
      .toLowerCase();       // Change the product name to lowercase
  }
}
