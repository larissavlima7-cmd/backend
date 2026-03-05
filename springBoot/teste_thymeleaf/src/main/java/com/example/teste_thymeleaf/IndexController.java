package com.example.teste_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class IndexController {
 
    
    //metodo de Requisição do tipo GET
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView abriIndex() {
        ModelAndView mv = new ModelAndView("index");
        String mensagem = "Olá, Visitante!";
        mv.addObject("msg",mensagem);
        return mv; 
    }

    //criar as rotas de navegação
    //SOBRE
    @GetMapping("/sobre")
    public String abrirSobre() {
        return "sobre";
    }

    //PRODUTOS
    @GetMapping("/produto")
    public String abrirProduto() {
        return "produtos";
    }
    

    //CONTATO
    @GetMapping("/contato")
    public String abrirContato() {
        return "contato";
    }

    //metodo para enciar o formulario com o nome do usuario
    @PostMapping("/home")
    public ModelAndView postHome(@RequestParam ("nome") String nome) {
        ModelAndView mv = new ModelAndView("index");
        String mensagem = "Olá, "+nome;
        mv.addObject("msg", mensagem);
        mv.addObject("nome","");
                
        return mv;
    }
    
    
    
    

}
