package com.github.rodsaraiva.cepi.test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.github.rodsaraiva.cepi.modelo.ApiResponse;
import com.github.rodsaraiva.cepi.modelo.Endereco;
import com.github.rodsaraiva.cepi.repository.EnderecoRepository;
import com.github.rodsaraiva.cepi.service.EnderecoService;
import com.github.rodsaraiva.cepi.viacep.ViacepResponse;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoServiceTest {

	@InjectMocks
	private EnderecoService service;

	@Mock
	private EnderecoRepository repository;

	@Mock
	private RestTemplate restTemplate;

	@Test(expected = IllegalArgumentException.class)
	public void deveFalharQuandoCepEInvalido() {

		String cep = "1234567";
		service.getEndereco(cep);
	}

	@Test
	public void deveRetornarCepExistenteNaBaseDeDados() {

		List<Endereco> enderecosMocked = new ArrayList<Endereco>();
		enderecosMocked.add(new Endereco("12345678"));

		when(repository.findByCep(anyString())).thenReturn(enderecosMocked);

		String cepExistenteNoBanco = "12345678";

		ApiResponse response = service.getEndereco(cepExistenteNoBanco);

		Assert.assertEquals(cepExistenteNoBanco, response.getCep());
	}

	@Test
	public void deveRetornarCepNaoExistenteNaBaseDeDados() {

		List<Endereco> enderecosMocked = new ArrayList<Endereco>();
		ViacepResponse viacepResponse = new ViacepResponse("12345678");

		when(repository.findByCep(anyString())).thenReturn(enderecosMocked);
		when(restTemplate.getForObject(anyString(), any())).thenReturn(viacepResponse);

		String cep = "12345678";
		ApiResponse response = service.getEndereco(cep);

		Assert.assertEquals(cep, response.getCep());
		verify(repository).save(any());
		verify(restTemplate).getForObject(anyString(), any());
	}

}
