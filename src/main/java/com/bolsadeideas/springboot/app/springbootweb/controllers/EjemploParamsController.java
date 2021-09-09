package com.bolsadeideas.springboot.app.springbootweb.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/params")
public class EjemploParamsController {
    
    @GetMapping(value="/")
    public String index() {
        return "params/index";
    }
    
    @GetMapping("/string")
    public String param(@RequestParam(value = "text", required = false, defaultValue = "no hubo valor") String texto, Model model) {
        model.addAttribute("resultado", "El valor del parametro es: ".concat(texto));
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute(
            "resultado", "El saludo enviado es: '"+saludo+"' el numero enviado es: '"+numero+"'"
        );
        return "params/ver";
    }

    @GetMapping("/mix-params-req")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }
        model.addAttribute(
            "resultado", "El saludo enviado es: '"+saludo+"' el numero enviado es: '"+numero+"'"
        );
        return "params/ver";
    }
    
}
