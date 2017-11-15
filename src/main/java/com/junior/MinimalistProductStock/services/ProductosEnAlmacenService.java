package com.junior.MinimalistProductStock.services;

import com.junior.MinimalistProductStock.entities.ProductosEnAlmacen;
import org.springframework.data.repository.CrudRepository;

public interface ProductosEnAlmacenService extends CrudRepository<ProductosEnAlmacen, Long> {
}
