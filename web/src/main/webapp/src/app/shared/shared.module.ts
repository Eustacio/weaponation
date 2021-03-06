import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CarouselModule } from 'primeng/carousel';
import { ButtonModule } from 'primeng/button';

import { ShowcaseComponent } from './showcase/showcase.component';
import { EllipsisPipe } from './pipes/ellipsis/ellipsis.pipe';

@NgModule({
  imports: [
    CommonModule,
    CarouselModule,
    ButtonModule
  ],
  declarations: [
    ShowcaseComponent,
    EllipsisPipe
  ],
  exports: [
    ShowcaseComponent,
    EllipsisPipe
  ]
})
export class SharedModule {}
