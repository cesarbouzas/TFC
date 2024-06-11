import {NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SobreMiComponent } from './pages/sobreMi/sobreMi.component';
import { NotFoundComponent } from './pages/notFound/notFound.component';
import { IotComponent } from './pages/iot/iot.component';
import { LangosteriaComponent } from './pages/langosteira/langosteira.component';





const routes: Routes = [


  {path:'langosteira',component:LangosteriaComponent},
  {path:'estudios',component:NotFoundComponent},
  {path:'iot',component:IotComponent},
  {path:'zonaB',component:NotFoundComponent},
  {path:'sobreMi',component:SobreMiComponent},
  {path:'',component:SobreMiComponent},
  {path: '**', component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
