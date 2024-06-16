package com.ontimize.hr.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ontimize.hr.api.core.service.ISensoresDistanciaService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/sensoresDistancia")

public class SensoresDistanciaRestController extends ORestController<ISensoresDistanciaService> {
@Autowired 
private ISensoresDistanciaService sensoresDistanicaService;
	
	@Override
	public ISensoresDistanciaService getService() {
		// TODO Auto-generated method stub
		return this.sensoresDistanicaService;
	}

	
	
}
