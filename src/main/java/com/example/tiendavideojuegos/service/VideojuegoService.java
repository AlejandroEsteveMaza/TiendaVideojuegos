/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.tiendavideojuegos.service;

import com.example.tiendavideojuegos.model.Videojuego;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface VideojuegoService {
    
    public List<Videojuego> listarVideojuego();
    
    public List<Videojuego> listarPorDistribuidor(int id);
    
    public List<Videojuego> listadoPorNombre(String nombre);
    
    public void crearVideojuego(Videojuego videojuego, String urlImagen);
    
}
