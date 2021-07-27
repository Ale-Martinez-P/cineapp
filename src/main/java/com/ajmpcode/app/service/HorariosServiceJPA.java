package com.ajmpcode.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ajmpcode.app.model.Horario;
import com.ajmpcode.app.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements IHorariosService{
	
	@Autowired
	private HorariosRepository horariosRepo;

	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);		
	}

	@Override
	public void insertar(Horario horario) {
		horariosRepo.save(horario);
	}

	@Override
	public List<Horario> buscarTodos() {
		return horariosRepo.findAll();
	}

	@Override
	public Page<Horario> buscarTodos(Pageable page) {
		return horariosRepo.findAll(page);
	}

	@Override
	public void eliminar(int idHorario) {
		horariosRepo.deleteById(idHorario);
	}

	@Override
	public Horario buscarPorId(int idHorario) {
		Optional<Horario> optional = horariosRepo.findById(idHorario);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
