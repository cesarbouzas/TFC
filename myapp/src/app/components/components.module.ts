import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { AppRoutingModule } from '../app-routing.module';
import { TunelMapComponent } from './tunelmap/tunelmap.component';
import { OficinaMapComponent } from './oficinamap/oficinamap.component';
import { FotoMatrizComponent } from './foto-matriz/foto-matriz.component';
import { FormularioFotoComponent } from './FormularioFoto/FormularioFoto.component';
import { NgbCarouselModule, NgbModule, NgbSlide } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EmpleadosInfoComponent } from './empleados-info/empleados-info.component';


@NgModule({
declarations:[
  FooterComponent,
  HeaderComponent,
  TunelMapComponent,
  OficinaMapComponent,
  FotoMatrizComponent,
  FormularioFotoComponent,
  EmpleadosInfoComponent,


],
imports:[
CommonModule,
  FormsModule,
  NgbModule,
  AppRoutingModule,
  NgbCarouselModule,
  NgbSlide
],
exports:[
FooterComponent,
HeaderComponent,
TunelMapComponent,
FotoMatrizComponent,
OficinaMapComponent,
FormularioFotoComponent,
EmpleadosInfoComponent,

],
schemas: [CUSTOM_ELEMENTS_SCHEMA],
})

export class ComponentsModule   {}

