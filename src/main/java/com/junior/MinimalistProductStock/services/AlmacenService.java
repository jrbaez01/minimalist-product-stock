package com.junior.MinimalistProductStock.services;

import com.junior.MinimalistProductStock.entities.Almacen;
import org.springframework.data.repository.CrudRepository;

public interface AlmacenService extends CrudRepository<Almacen, Long> {
}
