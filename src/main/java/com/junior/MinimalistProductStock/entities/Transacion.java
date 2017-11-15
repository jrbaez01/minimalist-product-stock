package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACIONES")
public class Transacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long almacenID;

    private Long transacionTipoID;

    private String descripcion;

    private Date fecha;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "almacenid", referencedColumnName = "id")
//    private Almacen almacen;
//
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "transacionTipoid", referencedColumnName = "id")
//    private TransacionTipo transacionTipo;

    /*
     * Getters and Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlmacenID() {
        return almacenID;
    }

    public void setAlmacenID(Long almacenID) {
        this.almacenID = almacenID;
    }

    public Long getTransacionTipoID() {
        return transacionTipoID;
    }

    public void setTransacionTipoID(Long transacionTipoID) {
        this.transacionTipoID = transacionTipoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
