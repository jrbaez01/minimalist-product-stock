package com.junior.MinimalistProductStock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

    @RequestMapping("/")
    public String indexAction (ModelMap model) {
        model.addAttribute("name", "Mundo");
        return "index"; // return twig template!
    }
}
