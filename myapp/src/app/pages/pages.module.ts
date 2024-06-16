import { NgModule } from '@angular/core';
import { ComponentsModule } from '../components/components.module';
import { SobreMiComponent } from './sobreMi/sobreMi.component';
import { NotFoundComponent } from './notFound/notFound.component';
import { IotComponent } from './iot/iot.component';
import { CommonModule } from '@angular/common';
import { LangosteriaFotosComponent } from './langosteira/langosteiraFotos/langosteiraFotos.component';
import { LangosteiraEmpleadosComponent } from './langosteira/langosteiraEmpleados/langosteiraEmpleados.component';
import { RepositorioComponent } from './repositorio/repositorio.component';
import { SafeUrlPipe } from '../safe-url.pipe';






@NgModule({
  declarations: [
  SobreMiComponent,
  NotFoundComponent,
  IotComponent,
  LangosteriaFotosComponent,
  LangosteiraEmpleadosComponent,
  RepositorioComponent,
SafeUrlPipe



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
    LangosteiraEmpleadosComponent,
    RepositorioComponent

  ],
})
export class PagesModule { }
