import { ErrorType } from './error-type.enum';

export class ServiceError {

  constructor(public readonly errorType: ErrorType,
              public readonly message: string) {}
}
