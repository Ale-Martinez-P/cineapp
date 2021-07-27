package com.ajmpcode.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmpcode.app.model.Perfil;
import com.ajmpcode.app.repository.PerfilesRepository;

@Service
public class PerfilesServiceJPA implements IPerfilesService{
	
	@Autowired
	private PerfilesRepository perfilesRepo;

	@Override
	public void guardar(Perfil perfil) {
		perfilesRepo.save(perfil);
		
	}

}
