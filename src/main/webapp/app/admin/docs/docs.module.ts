import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { EcommerceEp4SharedModule } from 'app/shared/shared.module';

import { DocsComponent } from './docs.component';

import { docsRoute } from './docs.route';

@NgModule({
  imports: [EcommerceEp4SharedModule, RouterModule.forChild([docsRoute])],
  declarations: [DocsComponent],
})
export class DocsModule {}
