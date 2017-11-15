package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;
import java.io.Serializable;

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
}

class TransacionDetalleID implements Serializable {

    @Column(name = "transacion_id")
    private Long transacionID;

    @Column(name = "producto_id")
    private Long productoID;

    public TransacionDetalleID() {
    }

    public TransacionDetalleID(Long transacionID, Long productoID) {
        this.transacionID = transacionID;
        this.productoID = productoID;
    }

    public Long getTransacionID() {
        return transacionID;
    }

    public Long getProductoID() {
        return productoID;
    }
}