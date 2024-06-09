package com.ontimize.hr.model.core.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.exceptions.ValidateException;
import com.ontimize.hr.api.core.service.ICodigoService;
import com.ontimize.hr.model.core.dao.CodigoDao;
import com.ontimize.hr.model.core.tools.ControlFields;
import com.ontimize.hr.model.core.tools.EntityResultWrong;
import com.ontimize.hr.model.core.tools.ErrorMessage;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("CodigoService")
@Lazy


public class CodigoService implements ICodigoService {
	@Autowired
	private CodigoDao dao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
@Autowired 
	ControlFields cf;
	
	
	@Override
	public EntityResult codigoQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(this.dao,keyMap,attrList);
	}

	@Override
	public EntityResult codigoInsert(Map<String, Object> data) throws OntimizeJEERuntimeException {
		EntityResult resultado = new EntityResultWrong();
		try {

			cf.reset();
			cf.addBasics(dao.fields);
			List<String> required = new ArrayList<>() {
				{
					add(dao.ATTR_NUM);
					add(dao.ATTR_DESCRIPTION);
				}
			};
			cf.setRequired(required);
			cf.validate(data);
			resultado = daoHelper.insert(dao, data);
			resultado.setMessage("La foto fue cargada correctamente");

		} catch (ValidateException e) {
			resultado = e.getEntityResult();
		} catch (DuplicateKeyException e) {
			resultado.setMessage("El codigo con id repetida");

		} catch (Exception e) {
			e.printStackTrace();
			resultado = new EntityResultWrong(ErrorMessage.ERROR);
		}
		return resultado;

	}

	@Override
	public EntityResult codigoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(dao, attrMap, keyMap);
	}

	@Override
	public EntityResult codigoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(dao, keyMap);
	}

}
