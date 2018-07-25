# cepi

API de consulta de cep feita em Java com Spring Boot e MySQL. Retorna um Json com o endereço do cep informado.

## Funcionalidades

- Busca de endereçco on-line
- Cache local de endereços

## Como testar

### Usando curl

```
$ curl http://localhost/consulta?cep=01001001

{
	"cep": "01001001",
	"logradouro": "Praça da Sé",
	"bairro": "Sé",
	"cidade": "São Paulo",
	"uf": "SP"
}

```
