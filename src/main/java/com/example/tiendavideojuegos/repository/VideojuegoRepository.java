/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendavideojuegos.repository;

import com.example.tiendavideojuegos.model.Videojuego;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 0019726
 */
public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
    
    @Query("select v from Videojuego v order by v.nombre")
    List<Videojuego> buscarTodos();
     
    @Query("select v from Videojuego v where v.distribuidor.id=?1 order by v.nombre")
    List<Videojuego> findByDistribuidor(int id);
    
    List<Videojuego> findByNombreContainingIgnoreCase(String nombre);
}
