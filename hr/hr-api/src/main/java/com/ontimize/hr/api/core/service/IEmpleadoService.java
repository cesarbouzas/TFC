package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IEmpleadoService {

 // Empleado
 public EntityResult empleadoQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult empleadoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult empleadoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult empleadoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}