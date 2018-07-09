import { ErrorType } from './error-type.enum';

export class ServiceError {

  constructor(public readonly errorType: ErrorType,
              public readonly message: string) {}

  static fromStatusCode(httpStatusCode: number): ServiceError | null {
    switch (httpStatusCode) {
      case 504:
        return new ServiceError(ErrorType.GATEWAY_TIMEOUT, 'Gateway Timeout');
    }
  }
}
