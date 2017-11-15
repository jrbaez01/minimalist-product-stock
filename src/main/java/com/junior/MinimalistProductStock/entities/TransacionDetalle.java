package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACION_DETALLES")
public class TransacionDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descripcion;

    /*
     * Getters and Setters @TODO
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
