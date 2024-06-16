package com.ontimize.hr.model.core.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.hr.model.core.tools.TypeCodes.type;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "ContactoDao")
@ConfigurationFile(
	configurationFile = "dao/ContactoDao.xml",
	configurationFilePlaceholder = "dao/placeholders.properties")

public class ContactoDao extends OntimizeJdbcDaoSupport {
	public static final String TAG="cto"+"_";
	public static final String ATTR_ID = TAG+"id";
	public static final String ATTR_COD_CATEGORIA="cat_id";
	 public static final String ATTR_COMPANY = TAG+"company";
	    public static final String ATTR_NOMBRECONTACTO = TAG+"nombrecontacto";
	    public static final String ATTR_TELEFONO = TAG+"telefono";
	    public static final String ATTR_EMAIL=TAG+"email";
	    public static final String ATTR_OBSERVACIONES=TAG+"observaciones";
	 
	    
	    
	    public static final Map<String,type> fields=new HashMap<>()
		{
		{
				put(ATTR_ID, type.INTEGER);
				put(ATTR_COD_CATEGORIA,type.INTEGER);
				put(ATTR_COMPANY, type.STRING);
				put(ATTR_NOMBRECONTACTO,type.TEXT);
				put(ATTR_NOMBRECONTACTO,type.TEXT);
				put(ATTR_TELEFONO,type.TEXT);
				put(ATTR_EMAIL,type.TEXT);
				put(ATTR_OBSERVACIONES,type.TEXT);
				
		}
		};
}