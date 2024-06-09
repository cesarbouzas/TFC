package com.ontimize.hr.model.core.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.hr.model.core.tools.TypeCodes.type;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "CodigoDao")
@ConfigurationFile(
	configurationFile = "dao/CodigoDao.xml",
	configurationFilePlaceholder = "dao/placeholders.properties")

public class CodigoDao extends OntimizeJdbcDaoSupport {
	public static final String TAG="cod"+"_";
	 public static final String ATTR_NUM = TAG+"num";
	    public static final String ATTR_DESCRIPTION = TAG+"description";
	
	    
	    
	    public static final Map<String,type> fields=new HashMap<>()
		{
		{
				put(ATTR_NUM, type.INTEGER);
				put(ATTR_DESCRIPTION, type.STRING);
			
				
		}
		};
}