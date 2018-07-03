import { Injectable } from '@angular/core';

import { Product } from '../shared/showcase/product';

@Injectable({
  providedIn: 'root'
})
export class DataExchangeService {

  selectedProduct: Product;
}
