import { Component, OnInit } from '@angular/core';
import { FotoServiceService } from '../../services/FotoService.service';
import { CodigoService } from '../../services/Codigo.service';

@Component({
  selector: 'app-FormularioFoto',
  templateUrl: './FormularioFoto.component.html',
  styleUrls: ['./FormularioFoto.component.css']
})
export class FormularioFotoComponent implements OnInit {

  opciones:any[]=[];
  opcionSeleccionada: any;
  imagenActual: string | ArrayBuffer | null = null;
  nombre: string ="";
  pk: number | null = null;
  codigo: number | null = null;
  fecha: string | null = null;

  constructor(private codigoService: CodigoService ,private fotoService: FotoServiceService) { }
  ngOnInit(): void {
    this.codigoService.getOptions().subscribe(data => {
      this.opciones = data;
      if (this.opciones.length > 0) {
        this.opcionSeleccionada = this.opciones[0].cod_num;
        this.fotoService.cambiarCodNum(this.opcionSeleccionada);
      }
    });
  }

  onSelectionChange() {
    console.log(this.opcionSeleccionada);
    this.fotoService.cambiarCodNum(this.opcionSeleccionada);
  }


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
      // Lectura del archivo como base64
      const reader = new FileReader();
      reader.onload = (e: any) => {
        // Asignar la imagen al atributo imagenActual
        this.imagenActual = e.target.result;
      };
      reader.readAsDataURL(file);
    }
  }

  guardarCambios() {
    if (this.imagenActual) {
      const formData = new FormData();
      let imageData: string | null = null;
      if (typeof this.imagenActual === 'string') {
        imageData = this.imagenActual.split(',')[1]; // Obtener la parte de la cadena después de la coma
      }

      formData.append('nombre', this.nombre);
      console.log(this.nombre);
      formData.append('pk', this.pk?.toString() || '');
      formData.append('fecha',this.fecha?.toString()||'');
      formData.append('cod', this.opcionSeleccionada);
      formData.append('archivo', imageData || ''); // Agregar solo la parte de la cadena Base64 al FormData

      this.fotoService.uploadFoto(formData).subscribe(
        (response) => {
          // Manejar la respuesta del servidor si es necesario
          console.log('Imagen cargada con éxito:', response);
          // Reiniciar valores
          this.pk = null;
          this.codigo= null;
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
