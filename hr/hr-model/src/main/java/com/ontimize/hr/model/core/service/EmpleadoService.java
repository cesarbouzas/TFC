package com.ontimize.hr.model.core.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.exceptions.ValidateException;
import com.ontimize.hr.api.core.service.IEmpleadoService;
import com.ontimize.hr.model.core.dao.EmpleadoDao;
import com.ontimize.hr.model.core.tools.ControlFields;
import com.ontimize.hr.model.core.tools.EntityResultWrong;
import com.ontimize.hr.model.core.tools.ErrorMessage;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("EmpledoService")
@Lazy


public class EmpleadoService implements IEmpleadoService {
	@Autowired
	private EmpleadoDao dao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
@Autowired 
	ControlFields cf;
	
	
	@Override
	public EntityResult empleadoQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(this.dao,keyMap,attrList);
	}

	@Override
	public EntityResult empleadoInsert(Map<String, Object> data) throws OntimizeJEERuntimeException {
		EntityResult  resultado= new EntityResultWrong();
		try {
			Path p=Paths.get((String)data.get(dao.ATTR_PICTURE));
			cf.reset();
			cf.addBasics(dao.fields);
			List<String> required=new ArrayList<>() {
				{
				add(dao.ATTR_NAME);
				add(dao.ATTR_SURNAME);
				add(dao.ATTR_TEL);
				add(dao.ATTR_OCCUPATION);
				add(dao.ATTR_SALARY);
				}
				};
				cf.setRequired(required);
				cf.validate(data);
				if(Files.exists(p)) {
					data.put(dao.ATTR_PICTURE, Files.readAllBytes(p));
					resultado=daoHelper.insert(dao, data);
					resultado.setMessage("La foto fue cargada correctamente");
				}else {
					resultado.setMessage("El archivo de foto no existe");
				}
		}catch (ValidateException e) {
			resultado=e.getEntityResult();
		}catch(DuplicateKeyException e) {
			resultado.setMessage("El empleado con id repetida" );
			
		}catch( Exception e) {
			e.printStackTrace();
			resultado=new EntityResultWrong(ErrorMessage.ERROR);
		}
		return resultado;
		
		
		
	}

	@Override
	public EntityResult empleadoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(dao, attrMap, keyMap);
	}

	@Override
	public EntityResult empleadoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(dao, keyMap);
	}

}
