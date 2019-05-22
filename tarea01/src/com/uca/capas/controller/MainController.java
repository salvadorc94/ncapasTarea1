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
public class MainController {
	
	@Autowired
	private LibroDAO libroDAO;
	
	
	@RequestMapping("/")
	public String initMain() {
		return "main";
	}
	
	@RequestMapping("/todos")
	public ModelAndView todos() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;
		int cantidad = 0;
		int cantidad2 = 0;
		try {
			 libros = libroDAO.findAll();
			 cantidad = libroDAO.howMany();
			 cantidad2 = libroDAO.authors();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		mav.addObject("cantidad1",cantidad);
		mav.addObject("cantidad2",cantidad2);
		mav.addObject("libros",libros);
		mav.setViewName("todos");
		return mav;
	}
	

}
