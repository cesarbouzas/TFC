package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IContactoService {

 // Contacto
 public EntityResult contactoQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult contactoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult contactoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult contactoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}