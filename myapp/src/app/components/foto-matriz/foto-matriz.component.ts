import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-foto-matriz',
  templateUrl: './foto-matriz.component.html',
  styleUrls: ['./foto-matriz.component.css']
})
export class FotoMatrizComponent implements OnInit {
  fotos: string[] = [];
  error: string | null = null;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.obtenerFotos();
  }

  obtenerFotos() {
    const url = 'http://localhost:33333/fotos/foto?columns=fot_foto';

    // Generar la cadena de autorización codificando las credenciales
    const basicAuthHeader = 'Basic ' + btoa('demo:demouser');

    // Crear las opciones para la solicitud HTTP
    const options = {
      headers: {
        'Authorization': basicAuthHeader
      }
    };

    // Hacer la solicitud HTTP con las opciones configuradas
    this.http.get<any>(url, options).subscribe(
      (response: any) => {
        console.log('Respuesta JSON:', response);
        // Procesar la respuesta JSON aquí
        if (response.data && Array.isArray(response.data)) {
          response.data.forEach((imageData: any) => {
            // Asumiendo que la propiedad 'fot_foto' contiene el objeto con los bytes de la imagen
            if (imageData.fot_foto && typeof imageData.fot_foto.bytes === 'string') {
              // Convertir los bytes a una URL de datos (data URL)
              const dataUrl = this.convertirBytesADataUrl(imageData.fot_foto.bytes);
              this.fotos.push(dataUrl);
            }
          });
        }
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

  convertirBytesADataUrl(bytea: string): string {
    // Convertir el string bytea a un array de bytes
    const byteCharacters = atob(bytea);
    const byteNumbers = new Array(byteCharacters.length);
    for (let i = 0; i < byteCharacters.length; i++) {
      byteNumbers[i] = byteCharacters.charCodeAt(i);
    }
    const byteArray = new Uint8Array(byteNumbers);

    // Crear un Blob a partir del array de bytes
    const blob = new Blob([byteArray], { type: 'image/jpeg' });

    // Crear una URL de datos (data URL) para el Blob
    const imageUrl = URL.createObjectURL(blob);

    return imageUrl;
  }


}
