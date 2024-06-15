package com.ontimize.hr.model.core.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.IFotoService;
import com.ontimize.hr.model.core.dao.FotoDao;
import com.ontimize.hr.model.core.tools.ControlFields;
import com.ontimize.hr.model.core.tools.EntityResultWrong;
import com.ontimize.hr.model.core.tools.ErrorMessage;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("FotoService")
@Lazy
public class FotoService implements IFotoService{
 @Autowired 
 private FotoDao dao;
 @Autowired 
 private DefaultOntimizeDaoHelper daoHelper;
 @Autowired
	ControlFields cf;
 @Override
 public EntityResult fotoInsert(Map<String, Object> data) throws OntimizeJEERuntimeException {
	 EntityResult resultado = new EntityResultWrong();

		try {
			data.get(dao.ATTR_PICTURE);
			
			Object  imagenObjeto=data.get(dao.ATTR_PICTURE);

			
			if ( imagenObjeto instanceof byte[]) {
				byte[] fotoBytes = 	(byte[])imagenObjeto;	
				cf.reset();
				cf.addBasics(dao.fields);
				List<String> required = new ArrayList<>() {
					{
						
						add(dao.ATTR_NAME);
						add(dao.ATTR_COD);
						add(dao.ATTR_PICTURE);					
					}
				};
				cf.setRequired(required);
				//cf.validate(data);
				data.put(dao.ATTR_PICTURE,fotoBytes);
					resultado = daoHelper.insert(dao, data);
			} else {
				resultado = new EntityResultWrong(ErrorMessage.ERROR);

			}
			
	} catch (DuplicateKeyException e) {
		resultado.setMessage("el id ya tiene foto asociada");
	} catch (Exception e) {
		e.printStackTrace();
		resultado = new EntityResultWrong(ErrorMessage.ERROR);
	}

	return resultado;
 }


@Override
public EntityResult fotoQuery(Map<String, Object> keyMap, List<String> attrList)
  throws OntimizeJEERuntimeException {
	System.out.print(this.daoHelper.query(dao, keyMap, attrList).toString());
 return this.daoHelper.query(this.dao, keyMap, attrList);
}


@Override
public EntityResult fotoDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
 return this.daoHelper.delete(this.dao, keyMap);
}

@Override
public ResponseEntity getFoto(Map<String, Object> filter, List<String> columns) throws OntimizeJEERuntimeException {
	// TODO Auto-generated method stub
	return null;
}


}
