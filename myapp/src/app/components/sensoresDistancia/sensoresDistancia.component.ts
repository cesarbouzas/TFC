import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";


@Component({
  selector: 'app-sensores-distancia',
  templateUrl: './sensoresDistancia.component.html',
  styleUrl: './sensoresDistancia.component.css',

})
export class SensoresDistanciaComponent {

  datos: any[] = []; // Arreglo para almacenar los datos

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.obtenerDatos(); // Llama a la función para obtener los datos al inicializar el componente
  }

  obtenerDatos() {
    // Reemplaza la URL con la URL de tu API
    const apiUrl = 'http://localhost:33333/sensoresDistancia/sensoresDistancia';

    this.http.get<any[]>(apiUrl).subscribe(
      (response) => {
        console.log('Respuesta JSON:', response);

        response.forEach((datosjson: any) => {

          datosjson.send_id
          datosjson.send_fecha,
          datosjson.send_med

        });
      },
      (error) => {
        console.error('Error al obtener los datos:', error);
      }
    );
  }

















}
