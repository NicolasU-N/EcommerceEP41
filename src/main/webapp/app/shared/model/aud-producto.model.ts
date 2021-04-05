import { Moment } from 'moment';
import { IProducto } from './producto.model';

export interface IAudProducto {
  id?: string;
  tipo?: string;
  fecha?: Moment;
  producto?: IProducto;
}

export class AudProducto implements IAudProducto {
  constructor(public id?: string, public tipo?: string, public fecha?: Moment, public producto?: IProducto) {}
}
