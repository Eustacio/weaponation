import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenubarModule } from 'primeng/menubar';
import { CarouselModule } from 'primeng/primeng';

import { ToolbarComponent } from './toolbar/toolbar.component';
import { BannerComponent } from './banner/banner.component';

@NgModule({
  imports: [
    CommonModule,
    MenubarModule,
    CarouselModule
  ],
  declarations: [
    ToolbarComponent,
    BannerComponent
  ],
  exports: [
    BannerComponent
  ]
})
export class CoreModule {}
