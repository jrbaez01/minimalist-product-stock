package com.junior.MinimalistProductStock.services;

import com.junior.MinimalistProductStock.entities.TransacionDetalle;
import org.springframework.data.repository.CrudRepository;

public interface TransacionDetalleService extends CrudRepository<TransacionDetalle, Long> {
}
