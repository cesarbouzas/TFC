import { NgModule } from '@angular/core';
import { ComponentsModule } from '../components/components.module';
import { SobreMiComponent } from './sobreMi/sobreMi.component';
import { NotFoundComponent } from './notFound/notFound.component';
import { IotComponent } from './iot/iot.component';
import { CommonModule } from '@angular/common';
import { LangosteriaFotosComponent } from './langosteira/langosteiraFotos/langosteiraFotos.component';
import { LangosteiraEmpleadosComponent } from './langosteira/langosteiraEmpleados/langosteiraEmpleados.component';






@NgModule({
  declarations: [
  SobreMiComponent,
  NotFoundComponent,
  IotComponent,
  LangosteriaFotosComponent,
  LangosteiraEmpleadosComponent




  ],
  imports: [
    CommonModule,
    ComponentsModule

  ],
  exports: [
    SobreMiComponent,
    NotFoundComponent,
    IotComponent,
    LangosteriaFotosComponent,
    LangosteiraEmpleadosComponent

  ],
})
export class PagesModule { }
