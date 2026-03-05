package com.example.escola_xyz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.escola_xyz.Repository.AdministradorRepository;
import com.example.escola_xyz.Repository.VerificaCadastroAdmRepository;
import com.example.escola_xyz.model.Administrador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AdministradorController {
    
    //Permite a Transformação de um OBj-Java em Entidade de BD
    //Cada Obj Criado Vira uma Linha do BD
    @Autowired
    AdministradorRepository ar;

    @Autowired
    VerificaCadastroAdmRepository vcar;

    //verificar acesso e cadastro
    boolean acessoAdm = false;

    //metodos
    //para navegar na página de cadastro
    @GetMapping("/cadastrar-adm")
    public String acessoCadastroAdmPage() {
        return "cadastro/cadastro-adm";
    }

    //método para enviar o cadastro do Adm
    @PostMapping("/cadastrar-adm")
    public ModelAndView cadastrarAdmBD(Administrador adm, RedirectAttributes attributes) {
        boolean verificarCpf = vcar.existsById(adm.getCpf()); //se existir retorna true, caso contrário retorna false
        ModelAndView mv=new ModelAndView("redirect:/login-adm");
        if(verificarCpf){
            //obj adm -> pega as informações do formulário e cria um obj da classe adm
            ar.save(adm);//salva no bd
            //criar uma mensagem para o usuário
            String mensagem = "Cadastro Realizado com Sucesso";
            //log oara o sistema
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem); //leva a mensagem para a tela view
            attributes.addFlashAttribute("classe", "verde"); //leva a mensagem para a tela view
        }else{ //deu errado, pessoa não pode se cadastrar
            String mensagem = "Cadastro não Permitido";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg",mensagem);
            attributes.addFlashAttribute("classe","vermelho");

        }
        
        return mv;
    }
    
    //METODO PARA PÁGINA DE LOGIN DO ADM
    @GetMapping("/login-adm")
    public String acessoLoginPageAdm() {
        return "login/login-adm";
    }

    //metodo para carregar a página interna após o login
    @PostMapping("/acesso-adm")
    public ModelAndView acessoAdm(@RequestParam String cpf, @RequestParam String senha, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-adm");
        boolean verificaCpf = ar.existsById(cpf);
        boolean verificaSenha = ar.findByCpf(cpf).getSenha().equals(senha);//pego o cpf, solicito a senha e comparo com a senha digitada

        if(verificaCpf && verificaSenha){
            acessoAdm = true;
        }else{
            String mensagem = "CPF ou Senha Incorreto";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe","vermelho");
            mv.setViewName("redirect:/login-adm");
        }

        
        return mv;
    }
    
    //acessar a página interna 
    @GetMapping("/interna-adm")
    public ModelAndView acessoInternaPageAdm(RedirectAttributes attributes) {
        String vaiPara  = "";
        if (acessoAdm) {// verifica se o usuário está logado
            vaiPara = "interna/interna-adm";// se estiver vai para a página interna
        }else{ //caso contrario nega o acesso e redireciona para o login
            String mensagem = "Acesso não Permitido";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg",mensagem);
            attributes.addFlashAttribute("classe", "vermelha");
            vaiPara = "redirect:/login-adm";

        }
        ModelAndView mv = new ModelAndView(vaiPara);
        return mv;
    }
    

}
