import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EcommerceEp4SharedModule } from 'app/shared/shared.module';
import { FacturaComponent } from './factura.component';
import { FacturaDetailComponent } from './factura-detail.component';
import { FacturaUpdateComponent } from './factura-update.component';
import { FacturaDeleteDialogComponent } from './factura-delete-dialog.component';
import { facturaRoute } from './factura.route';

@NgModule({
  imports: [EcommerceEp4SharedModule, RouterModule.forChild(facturaRoute)],
  declarations: [FacturaComponent, FacturaDetailComponent, FacturaUpdateComponent, FacturaDeleteDialogComponent],
  entryComponents: [FacturaDeleteDialogComponent],
})
export class EcommerceEp4FacturaModule {}
