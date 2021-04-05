import { IProducto } from './producto.model';

export interface IPedido {
  id?: string;
  producto?: IProducto;
  cantidad?: number;
}

export class Pedido implements IPedido {
  constructor(public id?: string, public producto?: IProducto, public cantidad?: number, public facturaId?: string) {}
}
