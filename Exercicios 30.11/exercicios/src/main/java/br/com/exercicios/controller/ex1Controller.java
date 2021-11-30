package br.com.exercicios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex1")
public class ex1Controller {
	
	@GetMapping
	public String ex1Show(){
		return "HABILIDADES: Atenção aos detalhes e Proatividade!<br /> MENTALIDADES: Responsabilidade pessoal e Persistência!";
	}

}
