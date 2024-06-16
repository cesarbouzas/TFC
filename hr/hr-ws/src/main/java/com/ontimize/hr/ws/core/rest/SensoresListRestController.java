package com.ontimize.hr.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ontimize.hr.api.core.service.ISensoresListService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/sensores")

public class SensoresListRestController extends ORestController<ISensoresListService> {
@Autowired 
private ISensoresListService sensoresListService;
	
	@Override
	public ISensoresListService getService() {
		// TODO Auto-generated method stub
		return this.sensoresListService;
	}

	
	
}
