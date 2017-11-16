package com.junior.MinimalistProductStock.controllers;

import com.junior.MinimalistProductStock.entities.Almacen;
import com.junior.MinimalistProductStock.entities.Producto;
import com.junior.MinimalistProductStock.services.AlmacenService;
import com.junior.MinimalistProductStock.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/mantenimiento/almacen")
public class AlmacenMantenimiento {

    @Autowired
    private AlmacenService almacenService;

    @GetMapping
    public String list (ModelMap model) {
        model.addAttribute("almacenes", almacenService.findAll());
        return "almacen/list";
    }

    @GetMapping(path="/{id}/editar")
    public String editar(@PathVariable long id, ModelMap model) {
        Almacen almacen = almacenService.findOne(id);
        model.addAttribute("almacen", almacen);
        return "almacen/editar";
    }

    @PostMapping("/actualizar")
    public ModelAndView actualizar(@RequestParam("id") long id,
                                   @RequestParam("nombre") String nombre) {
        Almacen almacen = almacenService.findOne(id);
        almacen.setNombre(nombre);
        almacenService.save(almacen);
        return new ModelAndView("redirect:/mantenimiento/almacen");
    }

    @GetMapping(path="/{id}/remover")
    public ModelAndView remover(@PathVariable long id) {
        almacenService.delete(id);
        return new ModelAndView("redirect:/mantenimiento/almacen");
    }

    @GetMapping(path="/nuevo")
    public String nuevo() {
        return "almacen/nuevo";
    }

    @PostMapping("/crear")
    public ModelAndView crear(@RequestParam("nombre") String nombre) {
        almacenService.save(new Almacen(nombre));
        return new ModelAndView("redirect:/mantenimiento/almacen");
    }
}
