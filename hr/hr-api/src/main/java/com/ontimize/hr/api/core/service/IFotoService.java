package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;


public interface IFotoService {
	
	//Foto
	 public EntityResult fotoQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	 public EntityResult fotoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
	 public EntityResult fotoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	 public ResponseEntity getFoto(Map<String, Object> filter, List<String> columns) throws OntimizeJEERuntimeException;
}
