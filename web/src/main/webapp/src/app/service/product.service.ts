import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { ServiceModule } from './service.module';

import { EntityService } from './entity-service';
import { Product } from '../model/product';

@Injectable({
  providedIn: ServiceModule
})
export class ProductService extends EntityService<Product> {

  constructor(private httpClient: HttpClient) {
    super(httpClient, '/api/products');
  }
}
