package com.ontimize.hr.model.core.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.hr.model.core.tools.TypeCodes.type;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "ContactoCategoriaDao")
@ConfigurationFile(
	configurationFile = "dao/ContactoCategoriaDao.xml",
	configurationFilePlaceholder = "dao/placeholders.properties")

public class ContactoCategoriaDao extends OntimizeJdbcDaoSupport {
	public static final String TAG="cat"+"_";
	 public static final String ATTR_ID = TAG+"id";
	    public static final String ATTR_NOMBRE = TAG+"nombre";
	    public static final String ATTR_DESCRIPCION = TAG+"descripcion";
	    
	 
	    
	    
	    public static final Map<String,type> fields=new HashMap<>()
		{
		{
				put(ATTR_ID, type.INTEGER);
				put(ATTR_NOMBRE, type.STRING);
				put(ATTR_DESCRIPCION,type.TEXT);
				
				
		}
		};
}