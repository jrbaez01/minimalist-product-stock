package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TRANSACIONES")
public class Transacion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "transacion_tipo_id")
    private Long transacionTipoID;

    @Column(name = "almacen_id")
    private Long almacenID;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "almacen_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Almacen almacen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transacion_tipo_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TransacionTipo transacionTipo;

    @OneToMany(targetEntity = TransacionDetalle.class, mappedBy = "transacion", fetch = FetchType.EAGER)
    private List<TransacionDetalle> transacionDetalles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TRANSACION_DETALLES",
            joinColumns = @JoinColumn(name = "transacion_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "id")
    )
    private List<Producto> productos;

    // Constructors
    public Transacion() {
    }

    public Transacion(Long transacionTipoID, Long almacenID, String descripcion) {
        this.transacionTipoID = transacionTipoID;
        this.almacenID = almacenID;
        this.descripcion = descripcion;
    }

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

    // Relationship objects
    public Almacen getAlmacen() {
        return almacen;
    }

    public TransacionTipo getTransacionTipo() {
        return transacionTipo;
    }

    public List<TransacionDetalle> getTransacionDetalles() {
        return transacionDetalles;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
