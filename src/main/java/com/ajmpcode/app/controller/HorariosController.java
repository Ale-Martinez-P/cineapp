package com.ajmpcode.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajmpcode.app.model.Horario;
import com.ajmpcode.app.model.Pelicula;
import com.ajmpcode.app.service.IHorariosService;
import com.ajmpcode.app.service.IPeliculasService;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Horario> listaHorarios = serviceHorarios.buscarTodos();
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Horario> listaHorarios = serviceHorarios.buscarTodos(page);
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}
	
	@GetMapping(value="/create")
	public String crear(@ModelAttribute Horario horario, Model model) {
		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", listaPeliculas);		
		
		return "horarios/formHorarios";		
	}
	
	/**
	 * Metodo para guardar el registro del Horario
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model,  RedirectAttributes attributes) {
		
		if (result.hasErrors()){
			List<Pelicula> listaPeliculas = servicePeliculas.buscarActivas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}
		serviceHorarios.insertar(horario);
		attributes.addFlashAttribute("msg", "El horario fue guardado!");
		//return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idHorario, Model model) {		
		Horario horario = serviceHorarios.buscarPorId(idHorario);			
		model.addAttribute("horario", horario);
		return "horarios/formHorario";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idHorario, RedirectAttributes attributes) {
		serviceHorarios.eliminar(idHorario);
		attributes.addFlashAttribute("msg", "El horario fue eliminado!");
		//return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate";
	}
	
	@ModelAttribute("peliculas")
	public List<Pelicula> getPeliculas(){
		return servicePeliculas.buscarActivas();
	}
	
	@InitBinder("horario")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));		
	}

}
