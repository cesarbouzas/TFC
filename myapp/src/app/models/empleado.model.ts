export class Empleado {
  id: string;
  nombre: string;
  apellido1: string;
  apellido2: string;
  puesto: string;
  telefono: string;
  salario?: number; // salario es opcional con el uso de '?'
  foto?: string; // foto es opcional
  password?: string; // password es opcional

  constructor(
    emp_id: string = '',
    emp_nombre: string = '',
    emp_apellido1: string = '',
    emp_apellido2: string = '',
    emp_puesto: string = '',
    emp_telefono: string = '',
    emp_salario?: number, // salario es opcional
    emp_foto?: string, // foto es opcional
    emp_password?: string // password es opcional
  ) {
    this.id = emp_id;
    this.nombre = emp_nombre;
    this.apellido1 = emp_apellido1;
    this.apellido2 = emp_apellido2;
    this.puesto = emp_puesto;
    this.telefono = emp_telefono;
    this.salario = emp_salario;
    this.foto = emp_foto;
    this.password = emp_password;
  }
}

