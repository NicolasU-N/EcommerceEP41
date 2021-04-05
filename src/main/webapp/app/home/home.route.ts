import { Routes } from '@angular/router';
import { CarritoComponent } from './carrito/carrito.component';
import { FacturasComponent } from './facturas/facturas.component';

import { HomeComponent } from './home.component';

export const HOME_ROUTES: Routes = [
  {
    path: '',
    component: HomeComponent,
    data: {
      authorities: [],
      pageTitle: 'home.title',
    },
  },
  {
    path: 'carrito',
    component: CarritoComponent,
    data: {
      authorities: [],
      pageTitle: 'home.title',
    },
  },
  {
    path: 'facturas',
    component: FacturasComponent,
    data: {
      authorities: [],
      pageTitle: 'home.title',
    },
  },
];
