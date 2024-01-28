/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendavideojuegos.controller;

import com.example.tiendavideojuegos.model.Videojuego;
import com.example.tiendavideojuegos.service.VideojuegoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 0019726
 */
@Controller
public class ListadoController {
    
    @Autowired
    VideojuegoService videojuegoservice;
    
    @GetMapping("/")
    public String ListadoVideojuegos(Model model){
        
        List<Videojuego> listado = videojuegoservice.listarVideojuego();
        model.addAttribute("lista",listado);
        return "listado";
    }
    
    @GetMapping("/videojuegopordistribuidor")
    public String ListadoPorDistribuidor(@RequestParam int id, Model model){
        List<Videojuego> listado = videojuegoservice.listarPorDistribuidor(id);
         model.addAttribute("lista",listado);
         return "listado";
    }
}
