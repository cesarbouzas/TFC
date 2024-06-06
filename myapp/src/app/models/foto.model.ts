export interface Foto {
  id: number;
  nombre: string;
  latitud: number;
  longitud: number;
  fecha: string;
  imagen: Blob; // Datos binarios de la imagen
}
