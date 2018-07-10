package com.github.rodsaraiva.cepi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepiController {

	@GetMapping("/consulta")
	public void consultaCep (@RequestParam(value="cep") String cep) {
		
		System.out.println("Deu certo, boa time");
		
	}
	
}
