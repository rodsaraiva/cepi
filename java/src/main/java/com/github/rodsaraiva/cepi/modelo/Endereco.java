package com.github.rodsaraiva.cepi.modelo;

import com.github.rodsaraiva.cepi.viacep.ViacepInfo;

public class Endereco {

	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;

	public Endereco(String cep, String logradouro, String bairro, String cidade, String uf) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Endereco(ViacepInfo viacepInfo) {
		this.cep = viacepInfo.getCep();
		this.logradouro = viacepInfo.getLogradouro();
		this.bairro = viacepInfo.getBairro();
		this.cidade = viacepInfo.getLocalidade();
		this.uf = viacepInfo.getUf();
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
