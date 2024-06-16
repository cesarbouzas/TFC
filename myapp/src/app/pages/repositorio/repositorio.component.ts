import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-repositorio',
  templateUrl: './repositorio.component.html',
  styleUrls: ['./repositorio.component.css']
})
export class RepositorioComponent implements OnInit {
  tipo: string = "";
  url: string = ""; // URL del repositorio
  descripcion: string = ""; // Descripción del repositorio

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.tipo = params['tipo'];
      this.handleTipo(this.tipo);
    });
  }

  handleTipo(tipo: string): void {
    if (tipo === 'DAM') {
      this.url = 'https://github.com/cesarbouzas/001_Rep_Personal/tree/main/002_FPS/DAM';
      this.descripcion = 'Este es el repositorio para el programa de Desarrollo de Aplicaciones Multiplataforma (DAM). Aquí encontrarás recursos y proyectos relacionados con el desarrollo de aplicaciones móviles y de escritorio.';
    } else if (tipo === 'DAW') {
      this.url = 'https://github.com/cesarbouzas/001_Rep_Personal/tree/main/002_FPS/DAW';
      this.descripcion = 'Este es el repositorio para el programa de Desarrollo de Aplicaciones Web (DAW). Incluye ejemplos y proyectos que abarcan tecnologías frontend y backend para la creación de aplicaciones web robustas.';
    } else if (tipo === 'OWI') {
      this.url = 'https://github.com/cesarbouzas/001_Rep_Personal/tree/main/001_Cursos/Cursos_Open';
      this.descripcion = 'Este repositorio contiene varios cursos de formación abiertos. Los cursos cubren una amplia gama de temas tecnológicos y están diseñados para el autoaprendizaje.';
    } else if (tipo === 'PFGDAW') {
      this.url = 'https://github.com/cesarbouzas/TFC';
      this.descripcion = 'Este es el repositorio para el Proyecto Final de Grado de Desarrollo de Aplicaciones Web (PFGDAW). Presenta el trabajo culminante del programa, incluyendo la documentación y el código fuente del proyecto.';
    } else {
      this.url = '';
      this.descripcion = 'Tipo de repositorio no válido.';
    }
  }
}
