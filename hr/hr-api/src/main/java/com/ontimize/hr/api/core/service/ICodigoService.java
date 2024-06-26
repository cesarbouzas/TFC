package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ICodigoService {

 // Codigo
 public EntityResult codigoQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult codigoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult codigoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult codigoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}