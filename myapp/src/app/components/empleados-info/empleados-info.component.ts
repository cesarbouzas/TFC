import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { EmpleadoService } from '../../services/Empleado.service';
import { Empleado } from '../../models/empleado.model';

@Component({
  selector: 'app-empleados-info',
  templateUrl: './empleados-info.component.html',
  styleUrls: ['./empleados-info.component.css']
})
export class EmpleadosInfoComponent implements OnInit {
  empleado: Empleado = new Empleado();
  error: string = '';
  fotos: string[] = [];

  constructor(private empleadoService: EmpleadoService) { }

  ngOnInit(): void {
    // Cargar la foto del empleado al iniciar el componente
    this.cargarFotoEmpleadoInicial();
  }

  cargarFotoEmpleadoInicial() {
    const idEmpleadoInicial = '1'; // Reemplaza con el ID real del empleado
    this.obtenerFoto(idEmpleadoInicial);
  }

  obtenerFoto(id: string) {
    this.empleadoService.obtenerFotoEmpleadoPorId(id).subscribe(
      (response: any) => {
        console.log('Respuesta JSON:', response);
        this.fotos = [];
        response.data.forEach((datosjson: any) => {
          if (datosjson.emp_foto && datosjson.emp_foto.bytes) {
            const dataUrl = this.convertirBytesADataUrl(datosjson.emp_foto.bytes);
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

  onFileChange(event: Event) {
    const file = (event.target as HTMLInputElement).files?.[0];
    if (file) {
      // Aquí puedes manejar la carga de una nueva foto y enviarla al servicio si es necesario
    }
  }

  onSubmit() {
    // Lógica para enviar el formulario
  }

  onUpdate() {
    // Lógica para actualizar el formulario
  }
  onIdChange() {
    // Obtener el nuevo valor del ID desde el modelo empleado
    const nuevoId = this.empleado.id;
    // Llamar a obtenerFoto con el nuevo ID
    this.obtenerFoto(nuevoId);
    this.cargarDatos(nuevoId);
  }
  cargarDatos(nuevoId: string) {
    this.empleadoService.obtenerDatosEmpleadoPorId(nuevoId).subscribe(
      (response: any) => {
        console.log('Respuesta JSON:', response);

        response.data.forEach((datosjson: any) => {
        this.empleado=new Empleado(
          datosjson.emp_id,
          datosjson.emp_nombre,
          datosjson.emp_apellido1,
          datosjson.emp_apellido2,
          datosjson.emp_puesto,
          datosjson.emp_telefono,
          datosjson.emp_password)
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
}
