package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACION_DETALLES")
public class TransacionDetalle {

    @EmbeddedId
    private TransacionDetalleID id;

    @Column(name = "cantidad")
    private Long cantidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transacion_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Transacion transacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "producto_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Producto producto;

    // constructor
    public TransacionDetalle() {
    }

    public TransacionDetalle(TransacionDetalleID id, Long cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    /*
         * Getters and Setters
         */
    public TransacionDetalleID getId() {
        return id;
    }

    public void setId(TransacionDetalleID id) {
        this.id = id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public void setProductoID(long productoID) {
        this.id.setProductoID(productoID);
    }

    public Transacion getTransacion() {
        return transacion;
    }

    public Producto getProducto() {
        return producto;
    }
}
