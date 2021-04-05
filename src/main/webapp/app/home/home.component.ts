import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

import { LoginModalService } from 'app/core/login/login-modal.service';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { ProductoService } from 'app/entities/producto/producto.service';
import { IProducto } from 'app/shared/model/producto.model';
import { CarritoService } from 'app/shared/util/carrito.service';

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['home.scss'],
})
export class HomeComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  authSubscription?: Subscription;

  productos: IProducto[] = [];

  constructor(
    private accountService: AccountService,
    private loginModalService: LoginModalService,
    private productoService: ProductoService,
    private carritoService: CarritoService
  ) {}

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
    this.obtenerProductos();
  }

  obtenerProductos(): void {
    this.productoService.query().subscribe(res => (this.productos = res.body!));
  }

  agregarAlCarrito(producto: IProducto): void {
    this.carritoService.addPedidosCart(producto);
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  login(): void {
    this.loginModalService.open();
  }

  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.authSubscription.unsubscribe();
    }
  }
}
