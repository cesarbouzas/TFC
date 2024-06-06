import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent   {
public titulo="Página personal";
public nombre="Cesar";
apellidos={
  primero:"Bouzas",
  segundo:"Soto"
}
correo="cesarbouzaspaw@gmail.es"




}
