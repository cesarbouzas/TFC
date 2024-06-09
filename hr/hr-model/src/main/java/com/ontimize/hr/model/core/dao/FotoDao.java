package com.ontimize.hr.model.core.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.hr.model.core.tools.TypeCodes.type;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository(value = "FotoDao")
@ConfigurationFile(
	configurationFile = "dao/FotoDao.xml",
	configurationFilePlaceholder = "dao/placeholders.properties")

public class FotoDao extends OntimizeJdbcDaoSupport {
	public static final String TAG="fot"+"_";
	 public static final String ATTR_ID = TAG+"id";
	    public static final String ATTR_NAME = TAG+"nombre";
	    public static final String ATTR_DATE = TAG+"fecha";
	    public static final String ATTR_PK = TAG+"pk";
	    public static final String ATTR_COD = TAG+"cod";
	    public static final String ATTR_PICTURE = TAG+"foto";
	    
	    
	    public static final Map<String,type> fields=new HashMap<>()
		{
		{
				put(ATTR_ID, type.INTEGER);
				put(ATTR_NAME, type.STRING);
				put(ATTR_DATE, type.DATE);
				put(ATTR_PK, type.INTEGER);
				put(ATTR_COD,type.INTEGER);
				put(ATTR_PICTURE,type.BYTETEA);
				
		}
		};
}
