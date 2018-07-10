import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { BehaviorSubject, Observable, Subject, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Entity } from '../model/entity';
import { ServiceError } from './error/service-error';
import { ServiceEvent } from './event/service-event.enum';
import { HttpStatus } from './http-status.enum';

export abstract class EntityService<T extends Entity> {

  // Http header for JSON requests
  protected readonly jsonHttpHeader: HttpHeaders;

  // BehaviorSubject used to publish data retrieved from the server
  private dataSubject: BehaviorSubject<T[]>;

  // Subject used to publish events
  private eventSubject: Subject<ServiceEvent>;

  // Subject used to publish server response errors
  private errorSubject: Subject<ServiceError>;

  protected constructor(private _httpClient: HttpClient,
                        protected endpointUrl: string) {
    this.jsonHttpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.dataSubject = new BehaviorSubject([]);
    this.eventSubject = new Subject();
    this.errorSubject = new Subject();
  }

  get events(): Observable<ServiceEvent> {
    return this.eventSubject.asObservable();
  }

  get errors(): Observable<ServiceError> {
    return this.errorSubject.asObservable();
  }

  getAll(): void {
    this._httpClient.get(this.endpointUrl, { observe: 'response' })
      .pipe(catchError((error: HttpErrorResponse) => this.handleResponseError(error)))
      .subscribe((response: HttpResponse<T[]>) => {
        // Publish the received data only if the response was HttpStatus.OK
        if (response.status == HttpStatus.OK)
          this.dataSubject.next(response.body);
        else
          console.error('Cannot handle response:', response);
      });
  }

  private handleResponseError(error: HttpErrorResponse): Observable<T> {
    // Publishes the error for it to be manipulated at the component level
    this.errorSubject.next(ServiceError.fromStatusCode(error.status));

    // Creates an Observable that emits no items to the Observer
    // and immediately emits an error notification.
    return throwError(error.message);
  }
}
