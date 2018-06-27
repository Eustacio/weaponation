import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShowcaseComponent } from './showcase/showcase.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    ShowcaseComponent
  ],
  exports: [
    ShowcaseComponent
  ]
})
export class SharedModule {}
