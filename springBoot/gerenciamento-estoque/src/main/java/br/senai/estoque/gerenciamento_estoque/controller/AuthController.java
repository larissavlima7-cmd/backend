package br.senai.estoque.gerenciamento_estoque.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    

	@GetMapping("/login")
	public String loginPage() {
		return "auth/login"; // templates/auth/login.html
	}

	@PostMapping("/login")
	public String login(@RequestParam String nif,
						@RequestParam String senha,
						HttpSession session,
						Model model) {
	
		boolean credenciaisOk = false;

		if (!credenciaisOk) {
			model.addAttribute("erro", "NIF ou senha inválidos.");
			return "auth/login";
		}

		// Sessão simples: marca que o usuário está logado
		session.setAttribute("usuarioLogado", true);
		session.setAttribute("nif", nif);

		// Após login, manda para a página interna
		return "redirect:/app";
	}

	@GetMapping("/cadastro")
	public String cadastroPage() {
		return "auth/cadastro"; // templates/auth/cadastro.html
	}

	@PostMapping("/cadastro")
	public String cadastro(@RequestParam String nome,
						  @RequestParam String nif,
						  @RequestParam String senha,
						  Model model) {
		model.addAttribute("erro", "Implementar cadastro no Service.");
		return "auth/cadastro";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
