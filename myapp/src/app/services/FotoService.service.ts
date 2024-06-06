import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Foto } from '../models/foto.model';

@Injectable({
  providedIn: 'root'
})
export class FotoServiceService {

  constructor(private http: HttpClient) { }




  buscarImagenPorId(id: number) {
    return this.http.get<any>(`http://localhost:33333/fotos/${id}`);
  }

  borrarImagenPorId(id: number) {
    return this.http.delete<any>(`http://localhost:33333/fotos/${id}`);
  }

  actualizarImagenPorId(id: number, nombre: string, latitud: number, longitud: number, fecha: string) {
    const data = {
      nombre: nombre,
      latitud: latitud,
      longitud: longitud,
      fecha: fecha
    };

    return this.http.put<any>(`http://localhost:33333/fotos/${id}`, data);
  }

  obtenerTodasLasFotos(): Observable<Foto[]> {
    return this.http.get<Foto[]>(`http://localhost:33333/fotos/foto`);
  }

  uploadFoto(formData: FormData): Observable<any> {
    const headers = new HttpHeaders()
      .set('Authorization', 'Basic ' + btoa('demo:demouser'))
      .set('Content-Type', 'application/json; charset=utf-8'); // Especificar UTF-8 en el encabezado Content-Type

    return this.http.post<any>('http://localhost:33333/fotos/upload', formData, { headers });
  }
}
