package com.ontimize.hr.model.core.service;



import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


import com.ontimize.hr.api.core.service.IContactoCategoriaService;
import com.ontimize.hr.model.core.dao.ContactoCategoriaDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("ContactoCategoriaService")
@Lazy


public class ContactoCategoriaService implements IContactoCategoriaService {
	@Autowired
	private ContactoCategoriaDao dao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	@Override
	public EntityResult contactoCategoriaQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(dao, keyMap, attrList);
	}
	@Override
	public EntityResult contactoCategoriaInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(dao, attrMap);
	}
	@Override
	public EntityResult contactoCategoriaUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(dao, attrMap, keyMap);
		
	}
	@Override
	public EntityResult contactoCategoriaDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		return this.daoHelper.delete(dao, keyMap);
	}


}
