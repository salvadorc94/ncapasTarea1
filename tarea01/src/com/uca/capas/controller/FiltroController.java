package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Controller
public class FiltroController {

	@Autowired
	private LibroDAO libroDAO;
	
	@RequestMapping("/search")
	public ModelAndView buscar(@RequestParam("titulo") String titulo, @RequestParam("criterio") String criterio ) {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;
		try {
			 libros = libroDAO.findSome(titulo, criterio);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		if(libros != null) {
			mav.addObject("cantidad",libros.size());
		}else {
			mav.addObject("cantidad",0);
		}
		
		mav.addObject("texto", titulo);
		mav.addObject("criterio", criterio);
		mav.addObject("libros",libros);
		mav.setViewName("search");
		return mav;
	}	
}
