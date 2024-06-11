import { NgModule } from '@angular/core';
import { ComponentsModule } from '../components/components.module';
import { SobreMiComponent } from './sobreMi/sobreMi.component';
import { NotFoundComponent } from './notFound/notFound.component';
import { IotComponent } from './iot/iot.component';
import { CommonModule } from '@angular/common';
import { LangosteriaComponent } from './langosteira/langosteira.component';





@NgModule({
  declarations: [
  SobreMiComponent,
  NotFoundComponent,
  IotComponent,
 LangosteriaComponent
  ],
  imports: [
CommonModule,
    ComponentsModule

  ],
  exports: [
    SobreMiComponent,
    NotFoundComponent,
    IotComponent,
    LangosteriaComponent
  ],
})
export class PagesModule { }
