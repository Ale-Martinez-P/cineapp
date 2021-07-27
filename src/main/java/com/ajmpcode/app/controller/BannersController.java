package com.ajmpcode.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajmpcode.app.model.Banner;
import com.ajmpcode.app.service.IBannersService;
import com.ajmpcode.app.util.Utileria;

@Controller
@RequestMapping("/banners/")
public class BannersController {
	
	@Autowired	
	private IBannersService serviceBanners;
	
	@GetMapping("/index")
	public String monstrarIndex(Model model) {
		List<Banner> banners = serviceBanners.buscarTodos();
		model.addAttribute("banners", banners);
		return "banners/listBanners";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Banner banner) {
		return "banners/formBanner";
	}
	
	@PostMapping("/save")
	public String guardar(Banner banner, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			banner.setArchivo(nombreImagen);
		}
		serviceBanners.insertar(banner);
		attributes.addFlashAttribute("mensaje", "Registro Guardado Exitosamente");		
		return "redirect:/banners/index";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idBanner, Model model) {		
		Banner banner = serviceBanners.buscarPorId(idBanner);			
		model.addAttribute("banner", banner);
		return "banners/formBanner";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idBanner, RedirectAttributes attributes) {
		// Eliminamos el registro del Banner
		serviceBanners.eliminar(idBanner);
		attributes.addFlashAttribute("msg", "El banner fue eliminado!.");
		return "redirect:/banners/index";
	}

}
