import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EcommerceEp4SharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

@NgModule({
  imports: [EcommerceEp4SharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent],
})
export class EcommerceEp4HomeModule {}
