package br.com.ellen.desafio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@NotEmpty
	private String name;
	private Endereco endereco;
	private Telefone teledone;
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios = new ArrayList();
}
