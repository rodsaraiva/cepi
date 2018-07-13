package com.github.rodsaraiva.cepi.modelo;

import com.github.rodsaraiva.cepi.viacep.ViacepResponse;

public class ApiResponse {

	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;

	public ApiResponse(String cep, String logradouro, String bairro, String cidade, String uf) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public ApiResponse(ViacepResponse viacepResponse) {
		this.cep = viacepResponse.getCep().replace("-", "");
		this.logradouro = viacepResponse.getLogradouro();
		this.bairro = viacepResponse.getBairro();
		this.cidade = viacepResponse.getLocalidade();
		this.uf = viacepResponse.getUf();
	}
	
	public ApiResponse(Endereco endereco) {
		this.cep = endereco.getCep().replace("-", "");
		this.logradouro = endereco.getLogradouro();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getLocalidade();
		this.uf = endereco.getUf();
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}
}
