import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})

export class CodigoService{

private apiURL="http://localhost:33333/codigo/codigo?columns=cod_num,cod_descripcion";


constructor (private http: HttpClient){ }

getOptions():Observable<any[]>{

  const headers = new HttpHeaders().set('Authorization', 'Basic ' + btoa('demo:demouser'))
  return this.http.get<any>(this.apiURL,{headers}).pipe(
    map(response=>response.data)
  );
}

}
