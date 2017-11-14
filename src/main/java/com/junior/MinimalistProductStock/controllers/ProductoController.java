package com.junior.MinimalistProductStock.controllers;

import com.junior.MinimalistProductStock.entities.Producto;
import com.junior.MinimalistProductStock.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/nuevo")
    public @ResponseBody String nuevoProducto(@RequestParam String nombre) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        productoService.save(producto);
        return "Saved: " + producto.toString();
    }

    @GetMapping(path="/lista")
    public @ResponseBody Iterable<Producto> getAllProducts() {
        return productoService.findAll();
    }
}
