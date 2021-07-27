package com.ajmpcode.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmpcode.app.model.Noticia;
import com.ajmpcode.app.repository.NoticiasRepository;

@Service
public class NoticiasServiceJPA implements INoticiasService{
	
	//Inyectamos una instancia desde nuestro Root ApplicationContext
		@Autowired
		private NoticiasRepository noticiasRepo;

	@Override
	public void guardar(Noticia noticia) {
		noticiasRepo.save(noticia);
		
	}

	@Override
	public List<Noticia> buscarUltimas() {
		List<Noticia> noticias = noticiasRepo.findTop3ByEstatusOrderByIdDesc("Activa");
		return noticias;
	}

	@Override
	public List<Noticia> buscarTodas() {
		return noticiasRepo.findAll();
	}

	@Override
	public void eliminar(int idNoticia) {
		noticiasRepo.deleteById(idNoticia);
	}

	@Override
	public Noticia buscarPorId(int idNoticia) {
		Optional<Noticia> optional = noticiasRepo.findById(idNoticia);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
