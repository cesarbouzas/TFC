package com.ontimize.hr.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.ICodigoService;
import com.ontimize.hr.api.core.service.IEmpleadoService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/codigo")

public class CodigoRestController extends ORestController<ICodigoService> {
@Autowired 
private ICodigoService codigoService;
	
	@Override
	public ICodigoService getService() {
		// TODO Auto-generated method stub
		return this.codigoService;
	}

	
	
}
