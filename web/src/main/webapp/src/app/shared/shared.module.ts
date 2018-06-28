import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CarouselModule } from 'primeng/carousel';
import { ButtonModule } from 'primeng/button';

import { ShowcaseComponent } from './showcase/showcase.component';

@NgModule({
  imports: [
    CommonModule,
    CarouselModule,
    ButtonModule
  ],
  declarations: [
    ShowcaseComponent
  ],
  exports: [
    ShowcaseComponent
  ]
})
export class SharedModule {}
