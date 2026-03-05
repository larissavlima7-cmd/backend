package com.example.escola_xyz.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


//anotação de Classe Controller (interagir view e model)
@Controller
public class IndexController {

    //metodo mais completo
    @GetMapping("/home")
    public ModelAndView acessoHomePage() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    //metodo mais simples de buscar uma página
    @GetMapping("")
    public String acessoHomepage2() {
        return "index";
    }

   
    

    
    
}
