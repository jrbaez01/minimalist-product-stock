package com.junior.MinimalistProductStock.controllers;

import com.junior.MinimalistProductStock.entities.Producto;
import com.junior.MinimalistProductStock.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/mantenimiento")
public class ProductoMantenimiento {

    @Autowired
    private ProductoService productoService;

    @RequestMapping("/producto")
    public String list (ModelMap model) {
        model.addAttribute("productos", productoService.findAll());
        return "producto/list"; // return twig template!
    }

    @GetMapping(path="/producto/{id}/editar")
    public String editar(@PathVariable long id, ModelMap model) {
        Producto producto = productoService.findOne(id);
        model.addAttribute("producto", producto);
        return "producto/editar";
    }

    @PostMapping("/producto/actualizar")
    public ModelAndView actualizar(@RequestParam("producto_id") long id,
                                   @RequestParam("nombre") String nombre) {
        Producto producto = productoService.findOne(id);
        producto.setNombre(nombre);
        productoService.save(producto);
        return new ModelAndView("redirect:/mantenimiento/producto");
    }

    @GetMapping(path="/producto/{id}/remover")
    public ModelAndView remover(@PathVariable long id) {
        productoService.delete(id);
        return new ModelAndView("redirect:/mantenimiento/producto");
    }

    @GetMapping(path="/producto/nuevo")
    public String nuevo() {
        return "producto/nuevo";
    }

    @PostMapping("/producto/crear")
    public ModelAndView crear(@RequestParam("nombre") String nombre) {
        productoService.save(new Producto(nombre));
        return new ModelAndView("redirect:/mantenimiento/producto");
    }
}
