package com.junior.MinimalistProductStock.controllers;

import com.junior.MinimalistProductStock.entities.Producto;
import com.junior.MinimalistProductStock.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {

    @Autowired
    private ProductoService productoService;

    @RequestMapping("/")
    public String list (ModelMap model) {
        model.addAttribute("productos", productoService.findAll());
        return "index"; // return twig template!
    }
}
