package com.example.tiendavideojuegos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videojuego")
public class Videojuego {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen_url;

    @ManyToOne
    @JoinColumn(name = "distribuidor_id")
    private Distribuidor distribuidor;
 
    public Videojuego() {
    }
    
    public Videojuego(Integer id, String nombre, String descripcion, String imagen_url, String urlImagen, Distribuidor distribuidor) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen_url = imagen_url;
		this.distribuidor = distribuidor;
	}

	public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }
    
    
}
