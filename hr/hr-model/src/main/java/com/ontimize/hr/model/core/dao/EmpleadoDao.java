package com.ontimize.hr.model.core.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.hr.model.core.tools.TypeCodes.type;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "EmpleadoDao")
@ConfigurationFile(
	configurationFile = "dao/EmpleadoDao.xml",
	configurationFilePlaceholder = "dao/placeholders.properties")

public class EmpleadoDao extends OntimizeJdbcDaoSupport {
	public static final String TAG="emp"+"_";
	 public static final String ATTR_ID = TAG+"id";
	    public static final String ATTR_NAME = TAG+"nombre";
	    public static final String ATTR_SURNAME = TAG+"apellido1";
	    public static final String ATTR_SURNAME2 = TAG+"apellido2";
	    public static final String ATTR_TEL=TAG+"telefono";
	    public static final String ATTR_OCCUPATION=TAG+"puesto";
	    public static final String ATTR_SALARY=TAG+"salario";
	    public static final String ATTR_PICTURE = TAG+"foto";
	    
	    
	    public static final Map<String,type> fields=new HashMap<>()
		{
		{
				put(ATTR_ID, type.INTEGER);
				put(ATTR_NAME, type.STRING);
				put(ATTR_SURNAME,type.TEXT);
				put(ATTR_SURNAME,type.TEXT);
				put(ATTR_SURNAME2,type.TEXT);
				put(ATTR_TEL,type.PHONE);
				put(ATTR_OCCUPATION,type.TEXT);
				put(ATTR_SALARY,type.DOUBLE);
				put(ATTR_PICTURE,type.TEXT);
				
		}
		};
}
