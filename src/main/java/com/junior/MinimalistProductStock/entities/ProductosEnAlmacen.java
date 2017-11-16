package com.junior.MinimalistProductStock.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCTOS_EN_ALMACEN")
public class ProductosEnAlmacen {

    @EmbeddedId
    private ProductosEnAlmacenID id;

    @Column(name = "cantidad")
    private Long cantidad;

    /*
     * Getters and Setters
     */
    public ProductosEnAlmacenID getId() {
        return id;
    }

    public void setId(ProductosEnAlmacenID id) {
        this.id = id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}

class ProductosEnAlmacenID implements Serializable {

    @Column(name = "producto_id")
    private Long productoID;

    @Column(name = "almacen_id")
    private Long almacenID;

    public ProductosEnAlmacenID() {
    }

    public ProductosEnAlmacenID(Long productoID, Long almacenID) {
        this.productoID = productoID;
        this.almacenID = almacenID;
    }

    public Long getProductoID() {
        return productoID;
    }

    public Long getAlmacenID() {
        return almacenID;
    }

    // @TODO https://vladmihalcea.com/2016/08/01/the-best-way-to-map-a-composite-primary-key-with-jpa-and-hibernate/
    // Implement some required methods
}
