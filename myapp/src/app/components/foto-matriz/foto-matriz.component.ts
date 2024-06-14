import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FotoServiceService } from '../../services/FotoService.service';
import { Foto } from '../../models/foto.model';

@Component({
  selector: 'app-foto-matriz',
  templateUrl: './foto-matriz.component.html',
  styleUrls: ['./foto-matriz.component.css']
})
export class FotoMatrizComponent implements OnInit {
  fotos: string[] = [];
  error: string | null = null;

  constructor(private fotoService: FotoServiceService) { }

  ngOnInit(): void {
    this.fotoService.currentCodNum.subscribe(codNum => {
      if (codNum !== null) {
        this.obtenerFotos(codNum);
      }
    });
  }

  obtenerFotos(codNum: string) {
    this.fotoService.obtenerFotosPorCodNum(codNum).subscribe(
      (response: any) => {
        console.log('Respuesta JSON:', response);
        this.fotos = []; // Limpiar la lista de fotos antes de agregar las nuevas
        response.data.forEach((fotoData: any) => {
          if (fotoData.fot_foto && fotoData.fot_foto.bytes) {
            const dataUrl = this.convertirBytesADataUrl(fotoData.fot_foto.bytes);
            this.fotos.push(dataUrl);
          }
        });
      },
      (error: HttpErrorResponse) => {
        if (error.status === 401) {
          this.error = 'Credenciales incorrectas. Por favor, vuelva a intentarlo.';
        } else {
          this.error = 'Error al obtener las fotos: ' + error.message;
        }
      }
    );
  }

  convertirBytesADataUrl(byteString: string): string {
    const byteCharacters = atob(byteString);
    const byteNumbers = new Array(byteCharacters.length);
    for (let i = 0; i < byteCharacters.length; i++) {
      byteNumbers[i] = byteCharacters.charCodeAt(i);
    }
    const byteArray = new Uint8Array(byteNumbers);

    const blob = new Blob([byteArray], { type: 'image/jpeg' });

    const imageUrl = URL.createObjectURL(blob);

    return imageUrl;
  }
}
