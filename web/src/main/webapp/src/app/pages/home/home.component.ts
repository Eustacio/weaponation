import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { ProductService } from '../../service/product.service';
import { ServiceEvent } from '../../service/event/service-event.enum';
import { ServiceError } from '../../service/error/service-error';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {

  private destroySubject: Subject<void>;

  constructor(private productService: ProductService) {
    this.destroySubject = new Subject();
  }

  ngOnInit(): void {
    this.registerForServiceEvents();
    this.registerForServiceErrors();
  }

  ngOnDestroy(): void {
    // Complete the Subject to avoid memory leaking when the component is destroyed
    this.destroySubject.next();
    this.destroySubject.complete();
  }

  private registerForServiceEvents(): void {
    this.productService.events
      .pipe(takeUntil(this.destroySubject))
      .subscribe((event: ServiceEvent) => {
        // TODO: properly handle events
      });
  }

  private registerForServiceErrors(): void {
    this.productService.errors
      .pipe(takeUntil(this.destroySubject))
      .subscribe((error: ServiceError) => {
        // TODO: properly handle errors
      });
  }
}
