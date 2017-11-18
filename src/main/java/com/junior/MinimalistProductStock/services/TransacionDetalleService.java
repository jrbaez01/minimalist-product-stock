package com.junior.MinimalistProductStock.services;

import com.junior.MinimalistProductStock.entities.TransacionDetalle;
import com.junior.MinimalistProductStock.entities.TransacionDetalleID;
import org.springframework.data.repository.CrudRepository;

public interface TransacionDetalleService extends CrudRepository<TransacionDetalle, Long> {
}
