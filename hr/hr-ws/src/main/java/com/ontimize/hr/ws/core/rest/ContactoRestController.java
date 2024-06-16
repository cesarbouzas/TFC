package com.ontimize.hr.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.IContactoService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/contacto")

public class ContactoRestController extends ORestController<IContactoService> {
@Autowired 
private IContactoService contactoService;
	
	@Override
	public IContactoService getService() {
		// TODO Auto-generated method stub
		return this.contactoService;
	}

	
	
}
