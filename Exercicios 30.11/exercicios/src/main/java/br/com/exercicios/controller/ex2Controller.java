package br.com.exercicios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex2")
public class ex2Controller {
	
	@GetMapping
	public String ex2Show() {
		return "Objetivo 1: Organização para estudos!<br />Objetivo 2: Aplicar meus conhecimentos para o projeto integrador!"
				+ "<br />Objetivo 3: Acompanhar meu grupo do Projeto Integrador para aumentar meu aprendizado!";
	}
}
