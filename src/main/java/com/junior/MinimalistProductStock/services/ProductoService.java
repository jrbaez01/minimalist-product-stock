package com.junior.MinimalistProductStock.services;

import com.junior.MinimalistProductStock.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoService extends CrudRepository<Producto, Long> {
}
