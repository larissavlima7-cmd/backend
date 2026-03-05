package com.example.rh.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.rh.Model.Funcionario;
import com.example.rh.Repository.FuncionarioRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FuncionarioController {
    //atributo
    @Autowired
    private FuncionarioRepository fr;

    @RequestMapping(value="/funcionario", method=RequestMethod.GET)
    public String abrirFuncionario(@RequestParam String param) {
        return "funcionario/funcionario";
    }

    //requisição para cadastrar funcionário no banco
    @RequestMapping(value = "/funcionario", method = RequestMethod.POST)
    public String gravarFuncionario (Funcionario funcionario){
        fr.save(funcionario);
        return "redirect:/funcionario";
    }
}