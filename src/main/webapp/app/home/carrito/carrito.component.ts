import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
import { FacturaService } from 'app/entities/factura/factura.service';
import { IFactura } from 'app/shared/model/factura.model';
import { IPedido } from 'app/shared/model/pedido.model';
import { IProducto } from 'app/shared/model/producto.model';
import { CarritoService } from 'app/shared/util/carrito.service';
import * as moment from 'moment';

@Component({
  selector: 'jhi-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.scss'],
})
export class CarritoComponent implements OnInit {
  form!: FormGroup;

  pedidos: IPedido[] = [];

  totalFactura = 0;

  userId!: string;

  constructor(
    private formBuilder: FormBuilder,
    private carritoService: CarritoService,
    private facturaService: FacturaService,
    private router: Router,
    private accountService: AccountService
  ) {
    this.form = this.formBuilder.group({});
  }

  ngOnInit(): void {
    this.accountService.getAuthenticationState().subscribe(account => (this.userId = account!.id));
    this.carritoService.userCart$.subscribe(pedidos => {
      this.pedidos = [...pedidos];
      this.pedidos.forEach(pedido => this.addPedidoControl(pedido));
      this.getTotalFactura();
    });
  }

  // Public methods

  // Getters forms

  getReactiveControl(controlName: string): AbstractControl | null {
    return this.form.get(controlName);
  }

  hacerPedido(): void {
    const factura: IFactura = {
      fecha: moment().startOf('seconds'),
      total: this.totalFactura,
      estado: 1,
      pedidos: this.pedidos,
    };

    this.facturaService.create(factura, this.userId).subscribe(() => {
      this.carritoService.removeAllPoductsInUserCart();
      this.router.navigate(['/']);
    });
  }

  // Events

  onInputFieldAmount(pedido: IPedido, control: AbstractControl | null): void {
    const amountFieldValue = control!.value;
    pedido.cantidad = isNaN(amountFieldValue) || amountFieldValue < 1 ? 1 : amountFieldValue;
    this.getTotalFactura();
  }

  onClickSpliceBillProduct(index: number, controlName: string): void {
    this.carritoService.spliceProductCart(index);
    this.form.removeControl(controlName);
    this.getTotalFactura();
  }

  onProductEmited(product: IProducto): void {
    this.carritoService.addPedidosCart(product);
    this.getTotalFactura();
  }

  // Utils

  getTotalFactura(): number {
    this.totalFactura = 0;
    this.pedidos.forEach(pedido => (this.totalFactura += pedido.cantidad! * pedido.producto!.precio!));
    return this.totalFactura;
  }

  // Private Methods

  private addPedidoControl(pedido: IPedido): void {
    this.form.addControl(
      pedido.producto!.id!,
      new FormControl(
        pedido.cantidad,
        Validators.compose([Validators.required, Validators.min(1), Validators.max(pedido.producto!.cantidadInventario!)])
      )
    );
  }
}
