package com.github.rodsaraiva.cepi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.github.rodsaraiva.cepi.modelo.ApiResponse;
import com.github.rodsaraiva.cepi.modelo.Endereco;
import com.github.rodsaraiva.cepi.repository.EnderecoRepository;
import com.github.rodsaraiva.cepi.viacep.ViacepResponse;

@Component
public class EnderecoService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EnderecoRepository repository;

	public ApiResponse getEndereco(String cep) {

		if (cep == null || !cep.matches("\\d{8}")) {
			throw new RuntimeException("Cep não pode ser nulo");
		}

		List<Endereco> enderecos = repository.findByCep(cep);

		if (!enderecos.isEmpty()) {
			Endereco endereco = enderecos.get(0);
			return new ApiResponse(endereco);
		}

		Endereco enderecoFromRemote = getFromRemoteApi(cep);

		repository.save(enderecoFromRemote);

		return new ApiResponse(enderecoFromRemote);

	}

	private Endereco getFromRemoteApi(String cep) {
		String viacepApiUrl = "https://viacep.com.br/ws/" + cep + "/json/";

		ViacepResponse viacepResponse = restTemplate.getForObject(viacepApiUrl, ViacepResponse.class);

		return new Endereco(viacepResponse);
	}

}
