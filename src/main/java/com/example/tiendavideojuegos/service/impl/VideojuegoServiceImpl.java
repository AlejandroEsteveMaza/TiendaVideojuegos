/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendavideojuegos.service.impl;

import com.example.tiendavideojuegos.model.Videojuego;
import com.example.tiendavideojuegos.repository.VideojuegoRepository;
import com.example.tiendavideojuegos.service.VideojuegoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 0019726
 */
@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    @Autowired
    VideojuegoRepository videojuegoRepository;
    
    @Override
    public List<Videojuego> listarVideojuego() {
       return videojuegoRepository.buscarTodos();
    }

    @Override
    public List<Videojuego> listarPorDistribuidor(int id) {
         return videojuegoRepository.findByDistribuidor(id);
    }

	@Override
	public List<Videojuego> listadoPorNombre(String nombre) {
		return videojuegoRepository.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public void crearVideojuego(Videojuego videojuego) {
		videojuegoRepository.save(videojuego);
		
	}

    
}
