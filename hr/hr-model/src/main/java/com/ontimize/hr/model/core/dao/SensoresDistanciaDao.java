package com.ontimize.hr.model.core.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.hr.model.core.tools.TypeCodes.type;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "SensoresDistanciaDao")
@ConfigurationFile(
	configurationFile = "dao/SensoresDistanciaDao.xml",
	configurationFilePlaceholder = "dao/placeholders.properties")

public class SensoresDistanciaDao extends OntimizeJdbcDaoSupport {
	public static final String TAG="senD"+"_";
	 public static final String ATTR_ID = TAG+"id";
	    public static final String ATTR_FECHA = TAG+"fecha";
	    public static final String ATTR_MED = TAG+"med";
	  
	    
	    
	    public static final Map<String,type> fields=new HashMap<>()
		{
		{
				put(ATTR_ID, type.INTEGER);
				put(ATTR_FECHA, type.STRING);
				put(ATTR_MED,type.DOUBLE);
				
			
				
				
		}
		};
}