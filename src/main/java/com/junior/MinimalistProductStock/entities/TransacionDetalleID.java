package com.junior.MinimalistProductStock.entities;

import javax.persistence.Column;
import java.io.Serializable;

public class TransacionDetalleID implements Serializable {

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

    public void setTransacionID(Long transacionID) {
        this.transacionID = transacionID;
    }

    public void setProductoID(Long productoID) {
        this.productoID = productoID;
    }
}