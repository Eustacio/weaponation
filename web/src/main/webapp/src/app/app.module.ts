import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { CoreModule } from './core/core.module';

import { AppComponent } from './app.component';
import { ToolbarComponent } from './core/toolbar/toolbar.component';
import { SharedModule } from './shared/shared.module';

@NgModule({
  imports: [
    BrowserModule,
    CoreModule,
    SharedModule
  ],
  declarations: [
    AppComponent
  ],
  bootstrap: [
    AppComponent,
    ToolbarComponent
  ]
})
export class AppModule {}
