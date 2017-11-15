package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACION_TIPOS")
public class TransacionTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    /*
     * Getters and Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
