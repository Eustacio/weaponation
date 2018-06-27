import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CarouselModule } from 'primeng/carousel';

import { ShowcaseComponent } from './showcase/showcase.component';

@NgModule({
  imports: [
    CommonModule,
    CarouselModule
  ],
  declarations: [
    ShowcaseComponent
  ],
  exports: [
    ShowcaseComponent
  ]
})
export class SharedModule {}
