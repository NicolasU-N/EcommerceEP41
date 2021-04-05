import { Moment } from 'moment';
import { IPedido } from 'app/shared/model/pedido.model';

export interface IFactura {
  id?: string;
  fecha?: Moment;
  total?: number;
  estado?: number;
  pedidos?: IPedido[];
}

export class Factura implements IFactura {
  constructor(public id?: string, public fecha?: Moment, public total?: number, public estado?: number, public pedidos?: IPedido[]) {}
}
