package com.ontimize.hr.ws.core.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ontimize.hr.api.core.service.IFotoService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/fotos")

public class FotoRestController extends ORestController<IFotoService> {

 @Autowired
 private IFotoService fotoService;

 @Override
 public IFotoService getService() {
	 
  return this.fotoService;
 }
 
 @PostMapping("/upload")
 public ResponseEntity<?> uploadFile(
         @RequestParam("nombre") String nombre,
         @RequestParam("pk") Integer pk,
         @RequestParam("cod") String codigo,
         @RequestParam("fecha") String fecha,
         @RequestParam("archivo") String archivo) {
     if (archivo.isEmpty()) {
         return ResponseEntity.badRequest().body("El archivo está vacío");
     }

     byte[] decodedImage = java.util.Base64.getDecoder().decode(archivo);//Angular
	 //byte[] fotoBytesPostman = ImageUtil.convertToByteArray(file.getInputStream());
	 HashMap<String, Object> datos = new HashMap<>();
	 datos.put("fot_nombre", nombre);
	 datos.put("fot_pk", pk);
	 datos.put("fot_cod", codigo);
	 datos.put("fot_fecha", fecha);
	 datos.put("fot_foto", decodedImage);
	 this.fotoService.fotoInsert(datos);
	 
	 String mensaje = "Archivo recibido correctamente. Nombre: " + nombre + ", PK: " + pk + ", codigo: " + codigo;
	 return ResponseEntity.ok().body(mensaje);
 }

}