import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Foto } from '../models/foto.model';


@Injectable({
  providedIn: 'root'
})
export class FotoServiceService {

  private codNumSource = new BehaviorSubject<string | null>(null);
  currentCodNum = this.codNumSource.asObservable();

  constructor(private http: HttpClient) {

   }

   private static getHeaders(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Basic ' + btoa('demo:demouser'));
  }

  cambiarCodNum(codNum: string) {

    this.codNumSource.next(codNum);
  }

  obtenerFotosPorCodNum(codNum: string): Observable<Foto[]> {
    const headers = FotoServiceService.getHeaders();
 // Convertir el código a número si es una cadena

 const body = {
   filter: {
     fot_cod: codNum // Pasar el código convertido a número
   },
   columns: [
     "fot_foto"
   ]
 };
    return this.http.post<Foto[]>(`http://localhost:33333/fotos/foto/search`, body, { headers });
  }

  borrarImagenPorId(codNum: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:33333/fotos/foto?cod_num=${codNum}`);
  }


  obtenerTodasLasFotos(): Observable<Foto[]> {
    return this.http.get<Foto[]>(`http://localhost:33333/fotos/foto`);
  }



  uploadFoto(formData: FormData): Observable<any> {
    const headers = FotoServiceService.getHeaders();
    return this.http.post<any>('http://localhost:33333/fotos/upload', formData, {headers}   );
  }
}
