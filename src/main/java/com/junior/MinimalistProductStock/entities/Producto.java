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
    private List<TransacionDetalle> transacionDetalles;

    @ManyToMany(mappedBy="productos",fetch=FetchType.EAGER)
    private List<Transacion> transaciones;

    // Constructors
    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

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

    public List<TransacionDetalle> getTransacionDetalles() {
        return transacionDetalles;
    }

    public List<Transacion> getTransaciones() {
        return transaciones;
    }

    public Long getCantidad() {
        // Sorry for the mess, need to do it quickly...

        Long total = 0L;
        for (Transacion transacion : this.getTransaciones()) {

            // Si el tipo de transacion es entrada, suma de lo contrario resta
            if (transacion.getTransacionTipoID() == 1) {
                total += transacion.getTransacionDetalles().get(0).getCantidad();
            } else {
                total -= transacion.getTransacionDetalles().get(0).getCantidad();
            }
        }

        return total;
    }
}
