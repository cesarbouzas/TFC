package com.ontimize.hr.model.core.service;



import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.IContactoService;
import com.ontimize.hr.model.core.dao.ContactoDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("ContactoService")
@Lazy


public class ContactoService implements IContactoService {
	@Autowired
	private ContactoDao dao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	@Override
	public EntityResult contactoQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(dao, keyMap, attrList);
	}
	@Override
	public EntityResult contactoInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(dao, attrMap);
	}
	@Override
	public EntityResult contactoUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(dao, attrMap, keyMap);
		
	}
	@Override
	public EntityResult contactoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		return this.daoHelper.delete(dao, keyMap);
	}


}
