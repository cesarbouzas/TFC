import { Component } from '@angular/core';

@Component({
  selector: 'app-iot',
  templateUrl: './iot.component.html',
  styleUrl: './iot.component.css'
})
export class IotComponent {
planoTunel:boolean=false;
planoOficina:boolean=false;
mostrarTunel() {
this.planoTunel=true;
this.planoOficina=false;
}
mostrarOficia() {
this.planoOficina=true;
this.planoTunel=false;
}


constructor(){

}

}
