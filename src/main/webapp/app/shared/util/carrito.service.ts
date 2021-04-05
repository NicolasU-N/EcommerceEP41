import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { IPedido, Pedido } from '../model/pedido.model';
import { IProducto } from '../model/producto.model';

@Injectable({
  providedIn: 'root',
})
export class CarritoService {
  private pedidos: IPedido[] = [];
  private userCart = new BehaviorSubject<IPedido[]>([]);

  userCart$ = this.userCart.asObservable();

  constructor() {}

  addPedidosCart(producto: IProducto): void {
    if (!this.pedidos.find(pd => pd.producto!.id === producto.id)) {
      const pedido = new Pedido();
      pedido.producto = producto;
      pedido.cantidad = 1;
      this.pedidos = [...this.pedidos, pedido];
      this.userCart.next(this.pedidos);
    }
  }

  spliceProductCart(index: number): void {
    this.pedidos = [...this.pedidos];
    this.pedidos.splice(index, 1);
    this.userCart.next(this.pedidos);
  }

  removeAllPoductsInUserCart(): void {
    this.pedidos = [];
    this.userCart.next(this.pedidos);
  }
}
