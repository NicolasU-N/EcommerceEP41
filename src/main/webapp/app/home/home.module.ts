import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EcommerceEp4SharedModule } from 'app/shared/shared.module';
import { HOME_ROUTES } from './home.route';
import { HomeComponent } from './home.component';
import { CarritoComponent } from './carrito/carrito.component';
import { FacturasComponent } from './facturas/facturas.component';

@NgModule({
  imports: [EcommerceEp4SharedModule, RouterModule.forChild(HOME_ROUTES)],
  declarations: [HomeComponent, CarritoComponent, FacturasComponent],
})
export class EcommerceEp4HomeModule {}
