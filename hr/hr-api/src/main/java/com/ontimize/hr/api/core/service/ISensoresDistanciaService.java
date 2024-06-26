package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;


public interface ISensoresDistanciaService{
	
	//SensoreDistancia
	public EntityResult sensoresDistanciaQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	 public EntityResult sensoresDistanciaInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
	 public EntityResult sensoresDistanciaUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	 public EntityResult sensoresDistanciaDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}
