
import {  Component } from '@angular/core';




@Component({
  selector: 'app-sobre-mi',
  templateUrl: './sobreMi.component.html',
  styleUrl: './sobreMi.component.css'

})
export class SobreMiComponent {
 pdfUrl="../../../assets/pdf/240329_CV_cesar_bouzas.pdf";
dowlodaCV() {
window.open(this.pdfUrl,"_blank");
}
}
