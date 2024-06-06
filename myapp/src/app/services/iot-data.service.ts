import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IotDataService {
  private baseUrl="http://localhost:8080"

  constructor(private http:HttpClient) { }
getDataFromTable(nombreTabla:string):Observable<any[]>{
  const url=`${this.baseUrl}/api/${nombreTabla}/data`;
  return this.http.get<any[]>(url);
}

}
