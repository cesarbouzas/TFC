package com.ontimize.hr.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ontimize.hr.api.core.service.IContactoCategoriaService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/contactoCategoria")

public class ContactoCategoriaRestController extends ORestController<IContactoCategoriaService> {
@Autowired 
private IContactoCategoriaService contactoCategoriaService;
	
	@Override
	public IContactoCategoriaService getService() {
		// TODO Auto-generated method stub
		return this.contactoCategoriaService;
	}

	
	
}
