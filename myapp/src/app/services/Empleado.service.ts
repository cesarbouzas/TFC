import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Empleado } from '../models/empleado.model';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  constructor(private httpClient: HttpClient) { }

  private static getHeaders(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Basic ' + btoa('demo:demouser'));
  }

  private empID = new BehaviorSubject<string | null>(null);
  currentCodNum = this.empID.asObservable();

  obtenerDatosEmpleadoPorId(empID: string): Observable<Empleado[]> {
    const headers = EmpleadoService.getHeaders();

    const body = {
      filter: {
        emp_id: empID
      },
      columns: [
        "emp_nombre",
        "emp_apellido1",
        "emp_apellido2",
        "emp_puesto",
        "emp_telefono",
        "emp_password"

      ]
    };

    return this.httpClient.post<Empleado[]>('http://localhost:33333/empleados/empleado/search', body, { headers })
      .pipe(
        catchError(error => {
          console.error('Error al obtener empleado por ID:', error);
          throw error;
        })
      );
  }
  obtenerFotoEmpleadoPorId(empID: string): Observable<Empleado[]> {
    const headers = EmpleadoService.getHeaders();

    const body = {
      filter: {
        emp_id: empID
      },
      columns: [
      "emp_foto"

      ]
    };

    return this.httpClient.post<Empleado[]>('http://localhost:33333/empleados/empleado/search', body, { headers })
      .pipe(
        catchError(error => {
          console.error('Error al obtener empleado por ID:', error);
          throw error;
        })
      );
  }
}
