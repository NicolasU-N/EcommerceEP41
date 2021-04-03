import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { EcommerceEp4SharedModule } from 'app/shared/shared.module';
import { EcommerceEp4CoreModule } from 'app/core/core.module';
import { EcommerceEp4AppRoutingModule } from './app-routing.module';
import { EcommerceEp4HomeModule } from './home/home.module';
import { EcommerceEp4EntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ActiveMenuDirective } from './layouts/navbar/active-menu.directive';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    EcommerceEp4SharedModule,
    EcommerceEp4CoreModule,
    EcommerceEp4HomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    EcommerceEp4EntityModule,
    EcommerceEp4AppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent],
  bootstrap: [MainComponent],
})
export class EcommerceEp4AppModule {}
