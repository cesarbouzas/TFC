package com.ontimize.hr.model.core.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.hr.model.core.tools.TypeCodes.type;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "SensoresListDao")
@ConfigurationFile(
	configurationFile = "dao/SensoresListDao.xml",
	configurationFilePlaceholder = "dao/placeholders.properties")

public class SensoresListDao extends OntimizeJdbcDaoSupport {
		public static final String TAG="sen"+"_";
		public static final String ATTR_ID = TAG+"id";
		public static final String ATTR_NOMBRE = TAG+"tipo";
	    public static final String ATTR_TIPO = TAG+"tipo";
	    public static final String ATTR_UBICACION = TAG+"ubicacion";
	    public static final String ATTR_ESTADO = TAG+"estado";
	
	    
	    
	    public static final Map<String,type> fields=new HashMap<>()
		{
		{
				put(ATTR_ID, type.INTEGER);
				put(ATTR_NOMBRE, type.STRING);
				put(ATTR_TIPO, type.STRING);
				put(ATTR_UBICACION,type.TEXT);
				put(ATTR_ESTADO,type.BOOLEAN);
				
		}
		};
}