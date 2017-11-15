package com.junior.MinimalistProductStock.services;

import com.junior.MinimalistProductStock.entities.Transacion;
import org.springframework.data.repository.CrudRepository;

public interface TransacionService extends CrudRepository<Transacion, Long> {
}
