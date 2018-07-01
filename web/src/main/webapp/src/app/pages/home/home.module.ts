import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { CoreModule } from '../../core/core.module';
import { SharedModule } from '../../shared/shared.module';

import { HomeComponent } from './home.component';

@NgModule({
  imports: [
    CommonModule,
    HomeRoutingModule,
    CoreModule,
    SharedModule
  ],
  declarations: [HomeComponent]
})
export class HomeModule {}
