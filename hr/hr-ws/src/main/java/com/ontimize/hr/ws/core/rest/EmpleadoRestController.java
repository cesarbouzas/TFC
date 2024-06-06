package com.ontimize.hr.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.IEmpleadoService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/empleados")

public class EmpleadoRestController extends ORestController<IEmpleadoService> {
@Autowired 
private IEmpleadoService empleadoService;
	
	@Override
	public IEmpleadoService getService() {
		// TODO Auto-generated method stub
		return this.empleadoService;
	}

	
	
}
