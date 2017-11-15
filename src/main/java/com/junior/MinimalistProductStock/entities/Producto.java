package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(targetEntity = TransacionDetalle.class, mappedBy = "producto", fetch = FetchType.EAGER)
    private Collection transacionDetalles;

    @ManyToMany(mappedBy="productos",fetch=FetchType.EAGER)
    private List<Transacion> transaciones;

    //Getters and Setters
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
