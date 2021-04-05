import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'producto',
        loadChildren: () => import('./producto/producto.module').then(m => m.EcommerceEp4ProductoModule),
      },
      {
        path: 'pedido',
        loadChildren: () => import('./pedido/pedido.module').then(m => m.EcommerceEp4PedidoModule),
      },
      {
        path: 'factura',
        loadChildren: () => import('./factura/factura.module').then(m => m.EcommerceEp4FacturaModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EcommerceEp4EntityModule {}
