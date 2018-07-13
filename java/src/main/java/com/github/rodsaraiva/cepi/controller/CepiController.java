package com.github.rodsaraiva.cepi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.rodsaraiva.cepi.modelo.ApiResponse;
import com.github.rodsaraiva.cepi.service.EnderecoService;

@RestController
public class CepiController {

	@Autowired
	private EnderecoService service;
	
	@GetMapping("/consulta")
	public ResponseEntity<ApiResponse> consultaCep (@RequestParam(value="cep") String cep) {
		
		try {

			ApiResponse apiResponse = service.getEndereco(cep);
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
			
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
