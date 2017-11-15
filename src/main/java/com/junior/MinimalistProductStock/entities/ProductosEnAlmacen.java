package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTOS_EN_ALMACEN")
public class ProductosEnAlmacen {

    @Id
    private Long almacenID;

    @Id
    private Long productoID;

    private Long cantidad;

    /*
     * Getters and Setters @TODO
     */
    public Long getAlmacenID() {
        return almacenID;
    }

    public void setAlmacenID(Long almacenID) {
        this.almacenID = almacenID;
    }

    public Long getProductoID() {
        return productoID;
    }

    public void setProductoID(Long productoID) {
        this.productoID = productoID;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
