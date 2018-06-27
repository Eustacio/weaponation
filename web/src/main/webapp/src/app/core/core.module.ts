import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenubarModule } from 'primeng/menubar';
import { CarouselModule } from 'primeng/primeng';

import { ToolbarComponent } from './toolbar/toolbar.component';
import { BannerComponent } from './banner/banner.component';
import { BreadcrumbComponent } from './breadcrumb/breadcrumb.component';

@NgModule({
  imports: [
    CommonModule,
    MenubarModule,
    CarouselModule
  ],
  declarations: [
    ToolbarComponent,
    BannerComponent,
    BreadcrumbComponent
  ],
  exports: [
    BannerComponent,
    BreadcrumbComponent
  ]
})
export class CoreModule {}
