import { Component, OnInit } from '@angular/core';
import { AccountService } from 'app/core/auth/account.service';
import { FacturaService } from 'app/entities/factura/factura.service';
import { IFactura } from 'app/shared/model/factura.model';

@Component({
  selector: 'jhi-facturas',
  templateUrl: './facturas.component.html',
  styleUrls: ['./facturas.component.scss'],
})
export class FacturasComponent implements OnInit {
  facturas: IFactura[] = [];

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.obtenerFacturas();
  }

  obtenerFacturas(): void {
    this.accountService.getAuthenticationState().subscribe(account => (this.facturas = account!.facturas));
  }
}
