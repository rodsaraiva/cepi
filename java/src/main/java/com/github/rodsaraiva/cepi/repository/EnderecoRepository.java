package com.github.rodsaraiva.cepi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.rodsaraiva.cepi.modelo.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

	List<Endereco> findByCep(String cep);

}
