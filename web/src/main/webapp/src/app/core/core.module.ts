import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenubarModule } from 'primeng/menubar';

import { ToolbarComponent } from './toolbar/toolbar.component';

@NgModule({
  imports: [
    CommonModule,
    MenubarModule
  ],
  declarations: [ToolbarComponent]
})
export class CoreModule {}
