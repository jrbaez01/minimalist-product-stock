package com.junior.MinimalistProductStock.controllers;

import com.junior.MinimalistProductStock.entities.*;
import com.junior.MinimalistProductStock.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

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

    @Autowired
    private ProductoService productoService;


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
        model.addAttribute( "productos", productoService.findAll() );

        return "transacion/editar";
    }

    @PostMapping("/actualizar")
    public ModelAndView actualizar(@RequestParam("id") long id,
                                   @RequestParam("transacion_tipo_id") long transacion_tipo_id,
                                   @RequestParam("almacen_id") long almacen_id,
                                   @RequestParam("producto_id") long producto_id,
                                   @RequestParam("producto_cantidad") long producto_cantidad,
                                   @RequestParam("descripcion") String descripcion) {

        Transacion transacion = transacionService.findOne(id);

        transacion.setAlmacenID(almacen_id);
        transacion.setTransacionTipoID(transacion_tipo_id);
        transacion.setDescripcion(descripcion);

        transacionService.save(transacion);

        TransacionDetalle transacionDetalle;
        transacionDetalle = transacion.getTransacionDetalles().get(0);
        transacionDetalleService.delete(transacionDetalle);
        transacionDetalle.setProductoID(producto_id);
        transacionDetalle.setCantidad(producto_cantidad);

        transacionDetalleService.save(transacionDetalle);

        return new ModelAndView("redirect:/transacion");
    }

    @GetMapping(path="/{id}/remover")
    public ModelAndView remover(@PathVariable long id) {
        transacionService.delete(id);
        return new ModelAndView("redirect:/transacion");
    }

    @GetMapping(path = "/nuevo")
    public String nuevo(ModelMap model,
                        @RequestParam(required = false) Optional<Long> transacion_tipo,
                        @RequestParam(required = false) Optional<Long> producto_id
                        ) {
        model.addAttribute("almacenes", almacenService.findAll() );
        model.addAttribute("transacion_tipos", transacionTipoService.findAll() );
        model.addAttribute("productos", productoService.findAll() );
        model.addAttribute("default_transacion_tipo", transacion_tipo.isPresent()?transacion_tipo.get():0);
        model.addAttribute("default_producto_id", producto_id.isPresent()?producto_id.get():0);
        return "transacion/nuevo";
    }

    @PostMapping("/crear")
    public ModelAndView crear(@RequestParam("transacion_tipo_id") long transacion_tipo_id,
                              @RequestParam("almacen_id") long almacen_id,
                              @RequestParam("producto_id") long producto_id,
                              @RequestParam("producto_cantidad") long producto_cantidad,
                              @RequestParam("descripcion") String descripcion,
                              @RequestParam(required = false) Optional<String> redirect) {

        Transacion transacion = new Transacion(
                transacion_tipo_id,
                almacen_id,
                descripcion
        );

        transacion = transacionService.save(transacion);

        TransacionDetalle transacionDetalle = new TransacionDetalle(
                new TransacionDetalleID(
                        transacion.getId(),
                        producto_id
                ),
                producto_cantidad
        );

        transacionDetalleService.save(transacionDetalle);

        return new ModelAndView("redirect:" + (redirect.isPresent()?redirect.get():"/"));
    }
}
