package com.bolsadeideas.springboot.app.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import com.bolsadeideas.springboot.app.springbootweb.models.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {
    
    static final String TITTLE = "tittle";
    static final String TEXT = "text";

    @Value("${text.indexController.index}")
    private String textoIndex;

    @Value("${text.indexController.perfil}")
    private String textoPerfil;

    @Value("${text.indexController.listar}")
    private String textoLista;

    @GetMapping(value = {"/index", "/", "/home"})
    public String index(Model model, ModelMap mmap){
        model.addAttribute(TITTLE, "Hola mundo");
        mmap.addAttribute(TEXT, textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombres("Gabriel");
        usuario.setApellidos("Cobeña");
        usuario.setEmail("gabriel@mail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute(TITTLE, "Perfil ".concat(usuario.getNombres()));
        model.addAttribute(TEXT, textoPerfil.concat(usuario.getNombres()));

        return "perfil";
    }
    
    @RequestMapping("/listar")
    public String listar(Model model){
        /*
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Andres", "Vernaza", "andres@correo.com"));
        usuarios.add(new Usuario("Pedro", "Salazar", "pedro@correo.com"));
        usuarios.add(new Usuario("Juan", "Benitez", "juan@correo.com"));
        */

        model.addAttribute(TITTLE, "Lista de usuarios");
        model.addAttribute(TEXT, textoLista);

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        return Arrays.asList(
            new Usuario("Andres", "Vernaza", "andres@correo.com"),
            new Usuario("Pedro", "Salazar", "pedro@correo.com"),
            new Usuario("Juan", "Benitez", "juan@correo.com")
        );
    }
}
