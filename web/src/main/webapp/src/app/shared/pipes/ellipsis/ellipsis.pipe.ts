import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ellipsisPipe'
})
export class EllipsisPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (!args)
      return value;

    if (value.length > args)
      return value.substring(0, args).concat('...');
    else
      return value;
  }
}
