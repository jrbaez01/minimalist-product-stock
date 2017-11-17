package com.junior.MinimalistProductStock.controllers;

import com.junior.MinimalistProductStock.entities.Almacen;
import com.junior.MinimalistProductStock.entities.Transacion;
import com.junior.MinimalistProductStock.entities.TransacionTipo;
import com.junior.MinimalistProductStock.services.AlmacenService;
import com.junior.MinimalistProductStock.services.TransacionDetalleService;
import com.junior.MinimalistProductStock.services.TransacionService;
import com.junior.MinimalistProductStock.services.TransacionTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping(path = "/transacion")
public class TransacionController {

    @Autowired
    private TransacionService transacionService;

    @Autowired
    private TransacionDetalleService transacionDetalleService;

    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private TransacionTipoService transacionTipoService;

    @GetMapping
    public String list (ModelMap model) {
        model.addAttribute("transaciones", transacionService.findAll());
        return "transacion/list";
    }

    @GetMapping(path="/{id}/editar")
    public String editar(@PathVariable long id, ModelMap model) {
        Transacion transacion = transacionService.findOne(id);
        model.addAttribute( "transacion", transacion);
        model.addAttribute( "transacion_tipos", transacionTipoService.findAll() );
        model.addAttribute( "almacenes", almacenService.findAll() );

        return "transacion/editar";
    }

    @PostMapping("/actualizar")
    public ModelAndView actualizar(@RequestParam("id") long id,
                                   @RequestParam("transacion_tipo_id") long transacion_tipo_id,
                                   @RequestParam("almacen_id") long almacen_id,
                                   @RequestParam("descripcion") String descripcion) {
        Transacion transacion = transacionService.findOne(id);

        transacion.setAlmacenID(almacen_id);
        transacion.setTransacionTipoID(transacion_tipo_id);
        transacion.setDescripcion(descripcion);

        transacionService.save(transacion);
        return new ModelAndView("redirect:/transacion");
    }

    @GetMapping(path="/{id}/remover")
    public ModelAndView remover(@PathVariable long id) {
        transacionService.delete(id);
        return new ModelAndView("redirect:/transacion");
    }

    @GetMapping(path = "/nuevo")
    public String nuevo(ModelMap model) {
        model.addAttribute("almacenes", almacenService.findAll() );
        model.addAttribute("transacion_tipos", transacionTipoService.findAll() );
        return "transacion/nuevo";
    }

    @PostMapping("/crear")
    public ModelAndView crear(@RequestParam("transacion_tipo_id") long transacion_tipo_id,
                              @RequestParam("almacen_id") long almacen_id,
                              @RequestParam("descripcion") String descripcion) {
        transacionService.save(new Transacion(
                transacion_tipo_id,
                almacen_id,
                descripcion
            )
        );
        return new ModelAndView("redirect:/transacion");
    }
}
