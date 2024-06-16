package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IContactoCategoriaService {

 // Codigo
 public EntityResult contactoCategoriaQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult contactoCategoriaInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult contactoCategoriaUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult contactoCategoriaDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}