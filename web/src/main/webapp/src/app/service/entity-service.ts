import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, Subject } from 'rxjs';

import { Entity } from '../model/entity';
import { ServiceError } from './error/service-error';
import { ServiceEvent } from './event/service-event.enum';

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
}
