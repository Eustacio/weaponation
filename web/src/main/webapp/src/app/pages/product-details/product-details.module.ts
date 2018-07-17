import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';

import { ProductDetailsRoutingModule } from './product-details-routing.module';
import { SharedModule } from '../../shared/shared.module';

import { ProductDetailsComponent } from './product-details.component';

@NgModule({
  imports: [
    CommonModule,
    ButtonModule,
    TableModule,
    SharedModule,
    ProductDetailsRoutingModule
  ],
  declarations: [ProductDetailsComponent]
})
export class ProductDetailsModule {}
