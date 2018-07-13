package com.github.rodsaraiva.cepi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.github.rodsaraiva.cepi.viacep.ViacepResponse;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;

	/**
	 * @deprecated hibernate only
	 */
	public Endereco() {
	}
	
	public Endereco(ViacepResponse viacepResponse) {
		this.cep = viacepResponse.getCep().replace("-", "");
		this.logradouro = viacepResponse.getLogradouro();
		this.complemento = viacepResponse.getComplemento();
		this.bairro = viacepResponse.getBairro();
		this.localidade = viacepResponse.getLocalidade();
		this.uf = viacepResponse.getUf();
	}
	
	public Long getId() {
		return id;
	}
	public String getCep() {
		return cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public String getUf() {
		return uf;
	}	
}
