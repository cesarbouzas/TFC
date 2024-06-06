import { Component } from '@angular/core';
import { FotoServiceService } from '../../services/FotoService.service';


@Component({
  selector: 'app-FormularioFoto',
  templateUrl: './FormularioFoto.component.html',
  styleUrls: ['./FormularioFoto.component.css']
})
export class FormularioFotoComponent {

  imagenActual: File | null = null;
  nombre: string ="";
  latitud: number | null = null;
  longitud: number | null = null;
  fecha: string | null = null;

  constructor(private fotoService: FotoServiceService) { }

  cargarImagen(event: any) {
    const files = event.target.files;
    if (files && files.length > 0) {
      const file = files[0];
      // Verificar si es un tipo de archivo válido (por ejemplo, imagen)
      if (!file.type.startsWith('image/')) {
        console.error('El archivo seleccionado no es una imagen.');
        return;
      }
      // Verificar el tamaño del archivo si es necesario
      const maxSizeInBytes = 10 * 1024 * 1024; // 10MB
      if (file.size > maxSizeInBytes) {
        console.error('El tamaño del archivo excede el límite máximo permitido.');
        return;
      }
      // Lectura del archivo
      const reader = new FileReader();
      reader.onload = (e: any) => {
        // Asignar la imagen al atributo imagenActual
        this.imagenActual = e.target.result;
      };
      reader.readAsDataURL(file);
    }
  }

  buscarImagen(id: number) {
    this.fotoService.buscarImagenPorId(id).subscribe(imagen => {
      this.imagenActual = imagen;
    });
  }



  guardarCambios() {
    if (this.imagenActual) {
      const formData = new FormData();
      formData.append('nombre', this.nombre || '');
      formData.append('latitud', this.latitud?.toString() || '');
      formData.append('longitud', this.longitud?.toString() || '');
      formData.append('file', this.imagenActual);

      this.fotoService.uploadFoto(formData).subscribe(
        (response) => {
          // Manejar la respuesta del servidor si es necesario
          console.log('Imagen cargada con éxito:', response);
          // Reiniciar valores

          this.latitud = null;
          this.longitud = null;
          this.fecha = null;
          this.imagenActual = null;
        },
        (error) => {
          // Manejar cualquier error que ocurra durante la carga de la imagen
          console.error('Error al cargar la imagen:', error);
        }
      );
    } else {
      console.warn('No se ha seleccionado ninguna imagen para cargar.');
    }
  }

  }





