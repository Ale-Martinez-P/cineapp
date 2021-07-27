package com.ajmpcode.app.service;

import java.util.List;

import com.ajmpcode.app.model.Noticia;

public interface INoticiasService {
	
	void guardar(Noticia noticia);
	List<Noticia> buscarUltimas();
	List<Noticia> buscarTodas();
	void eliminar(int idNoticia);
	Noticia buscarPorId(int idNoticia);

}
