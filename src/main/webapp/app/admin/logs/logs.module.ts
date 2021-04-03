import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { EcommerceEp4SharedModule } from 'app/shared/shared.module';

import { LogsComponent } from './logs.component';

import { logsRoute } from './logs.route';

@NgModule({
  imports: [EcommerceEp4SharedModule, RouterModule.forChild([logsRoute])],
  declarations: [LogsComponent],
})
export class LogsModule {}
