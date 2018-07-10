package com.github.rodsaraiva.cepi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.github.rodsaraiva.cepi.modelo.Endereco;
import com.github.rodsaraiva.cepi.viacep.ViacepInfo;

@Component
public class RemoteCepService {

	@Autowired
	private RestTemplate restTemplate;

	public Endereco getEndereco(String cep) {

		if (cep == null || !cep.matches("\\d{8}")) {
			throw new RuntimeException("Cep não pode ser nulo");
		}

		String viacepApiUrl = "https://viacep.com.br/ws/" + cep + "/json/";

		ViacepInfo viacepInfo = restTemplate.getForObject(viacepApiUrl, ViacepInfo.class);

		return new Endereco(viacepInfo);
	}

}
