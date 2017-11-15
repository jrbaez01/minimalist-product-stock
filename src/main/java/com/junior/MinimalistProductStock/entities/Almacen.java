package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ALMACENES")
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

//    @OneToMany(targetEntity = Transacion.class, mappedBy = "almacen", fetch = FetchType.EAGER)
//    private Collection transaciones;

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
