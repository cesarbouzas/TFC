import { NgModule } from '@angular/core';
import { ComponentsModule } from '../components/components.module';
import { SobreMiComponent } from './sobreMi/sobreMi.component';
import { NotFoundComponent } from './notFound/notFound.component';
import { IotComponent } from './iot/iot.component';
import { ConstruccionComponent } from './construccion/construccion.component';
import { CommonModule } from '@angular/common';





@NgModule({
  declarations: [
  SobreMiComponent,
  NotFoundComponent,
  IotComponent,
  ConstruccionComponent
  ],
  imports: [
CommonModule,
    ComponentsModule

  ],
  exports: [
    SobreMiComponent,
    NotFoundComponent,
    IotComponent,
    ConstruccionComponent
  ],
})
export class PagesModule { }
