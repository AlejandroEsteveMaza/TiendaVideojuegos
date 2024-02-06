/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendavideojuegos.controller;

import com.example.tiendavideojuegos.model.Videojuego;
import com.example.tiendavideojuegos.service.ImageUploadingService;
import com.example.tiendavideojuegos.service.VideojuegoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 0019726
 */
@Controller
public class ListadoController {

	@Autowired
	VideojuegoService videojuegoservice;

	@Autowired
	ImageUploadingService imageService;

	@GetMapping("/")
	public String ListadoVideojuegos(Model model) {

		List<Videojuego> listado = videojuegoservice.listarVideojuego();
		model.addAttribute("lista", listado);
		return "listado";
	}

	@GetMapping("/videojuegopordistribuidor")
	public String ListadoPorDistribuidor(@RequestParam int id, Model model) {
		List<Videojuego> listado = videojuegoservice.listarPorDistribuidor(id);
		model.addAttribute("lista", listado);
		return "listado";
	}

	@PostMapping("/")
	public String ListadoVideojuegosFiltrado(String buscar, Model model) {

		List<Videojuego> listado = videojuegoservice.listadoPorNombre(buscar);
		model.addAttribute("lista", listado);
		return "listado";
	}

	@GetMapping("/videojuego")
	public String FormularioVideojuego() {
		return "formulario";
	}

	@PostMapping("/videojuego")
	public String CrearVideojuego(@Validated Videojuego videojuego, @RequestParam("file") MultipartFile multipartFile,
			BindingResult result) {
		if (result.hasErrors()) {
			return "formulario";
		}
		String urlImagen = imageService.upload(multipartFile);
		videojuegoservice.crearVideojuego(videojuego, urlImagen);
		return "formulario"; 
	}

}
