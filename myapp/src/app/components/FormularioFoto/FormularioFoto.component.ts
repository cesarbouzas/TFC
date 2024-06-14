import { Component, OnInit, ChangeDetectorRef, ViewChild, ElementRef } from '@angular/core';
import { FotoServiceService } from '../../services/FotoService.service';
import { CodigoService } from '../../services/Codigo.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-FormularioFoto',
  templateUrl: './FormularioFoto.component.html',
  styleUrls: ['./FormularioFoto.component.css']
})
export class FormularioFotoComponent implements OnInit {

  opciones: any[] = [];
  opcionSeleccionada: any;
  imagenActual: string | ArrayBuffer | null = null;
  nombre: string = "";
  pk: number | null = null;
  fecha: string | null = null;
  mensaje: string = '';
  error: string | null = null;

  @ViewChild('fileInput') fileInput!: ElementRef;

  constructor(
    private codigoService: CodigoService,
    private fotoService: FotoServiceService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    this.loadOptions();
  }

  loadOptions(): void {
    this.codigoService.getOptions().subscribe(data => {
      this.opciones = data;
      if (this.opciones.length > 0) {
        const savedSelectedOption = localStorage.getItem('selectedOption');
        this.opcionSeleccionada = savedSelectedOption ? savedSelectedOption : this.opciones[0].cod_num;
        this.fotoService.cambiarCodNum(this.opcionSeleccionada);
      }
    });
  }

  onSelectionChange() {
    this.fotoService.cambiarCodNum(this.opcionSeleccionada);
    localStorage.setItem('selectedOption', this.opcionSeleccionada);
  }

  cargarImagen(event: any) {
    const files = event.target.files;
    if (files && files.length > 0) {
      const file = files[0];
      if (!file.type.startsWith('image/')) {
        console.error('El archivo seleccionado no es una imagen.');
        return;
      }
      const maxSizeInBytes = 10 * 1024 * 1024; // 10MB
      if (file.size > maxSizeInBytes) {
        console.error('El tamaño del archivo excede el límite máximo permitido.');
        return;
      }
      const reader = new FileReader();
      reader.onload = (e: any) => {
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
      formData.append('pk', this.pk?.toString() || '');
      formData.append('fecha', this.fecha?.toString() || '');
      formData.append('cod', this.opcionSeleccionada);
      formData.append('archivo', imageData || '');

      this.fotoService.uploadFoto(formData).subscribe(
        (response) => {
          console.log('Imagen cargada con éxito:', response);
          this.mensaje = 'Foto cargada con éxito.';
          this.resetForm(); // Reiniciar el formulario después de una carga exitosa
        },
        (error: HttpErrorResponse) => {
          console.error('Error al cargar la imagen:', error);
          this.error = 'Error al cargar la foto: ' + error.message;
        }
      );
    } else {
      console.warn('No se ha seleccionado ninguna imagen para cargar.');
    }
  }

  resetForm() {
    this.nombre = '';
    this.pk = null;
    this.fecha = null;
    this.imagenActual = null;
    this.mensaje = '';
    this.error = null;
    if (this.fileInput && this.fileInput.nativeElement) {
      this.fileInput.nativeElement.value = ''; // Limpiar el valor del input de tipo file
    }
    this.loadOptions(); // Recargar opciones después de reiniciar el formulario
  }
}
