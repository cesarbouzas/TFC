package com.ontimize.hr.model.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.ISensoresListService;

import com.ontimize.hr.model.core.dao.SensoresListDao;
import com.ontimize.hr.model.core.tools.ControlFields;
import com.ontimize.hr.model.core.tools.EntityResultWrong;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("SensoresService")
@Lazy


public class SensoresListService implements ISensoresListService {
	@Autowired
	private SensoresListDao dao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
@Autowired 
	ControlFields cf;
	
	
	@Override
	public EntityResult sensoresListQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(this.dao,keyMap,attrList);
	}

	@Override
	public EntityResult sensoresListInsert(Map<String, Object> data) throws OntimizeJEERuntimeException {
		
		try {
			
			cf.reset();
			cf.addBasics(dao.fields);
			List<String> required=new ArrayList<>() {
				{
				add(dao.ATTR_ID);
				add(dao.ATTR_NOMBRE);
				add(dao.ATTR_TIPO);
				add(dao.ATTR_UBICACION);
				add(dao.ATTR_ESTADO);
				}
				};
				cf.setRequired(required);
				//cf.validate(data);
				
		}catch (Exception e) {
			e.printStackTrace();
		}		
				
					return daoHelper.insert(dao, data);	
	}

	@Override
	public EntityResult sensoresListUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(dao, attrMap, keyMap);
	}

	@Override
	public EntityResult sensoresListDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(dao, keyMap);
	}

}