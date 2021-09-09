package com.bolsadeideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/")
    public String index(Model model){
        return "variables/index";
    }
    
    @GetMapping(value="/string/{text}")
    public String variables(@PathVariable(value = "text") String texto, Model model) {
        model.addAttribute("resultado", "El valor de la variable (@PathVariable) es: "+texto);
        return "variables/ver";
    }

    @GetMapping(value="/string/{text}/{number}")
    public String variables(@PathVariable(value = "text") String texto, @PathVariable(value = "number") Integer numero, Model model) {
        model.addAttribute("resultado", "El valor de la variable (@PathVariable) es: "+texto+" y numero: "+numero);
        return "variables/ver";
    }
    
}
