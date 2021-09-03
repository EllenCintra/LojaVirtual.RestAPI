package br.com.bytebank.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.Modelo.Cliente;
import br.com.bytebank.banco.Modelo.Conta;
import br.com.bytebank.banco.Modelo.ContaCorrente;
import br.com.bytebank.banco.Modelo.ContaPoupanca;

/**
 * 
 * @author ellen
 * Nesta classe, diferente de Teste e Teste2, foi utilizado o lambda e criação de classes anônimas para os critérios de ordenação de lista
 * No caso, por número da conta e nome do Titular.
 * Da forma antiga, usávamos as classes NumeroDaContaComparador e TitularDaContaComparados, que ao serem instanciadas, se tornavam Function Objects
 * Funcion Objects são objetos instaciados para serem utilizados pontualmente, em um local específico do código.
 * E justamente por isso, puderam ser substituídos por lambdas e classes anônimas.
 * 
 * Apenas interfaces com um método abstrato único é uma interface funcional que sua implementação pode ser tratada como expressões lambda.
 * As expressões lambda nos permitem tratar a funcionalidade como argumento de método e transmitir um bloco de código.
 *
 */

public class TesteOrdenacao {

	public static void main(String[] args) {
		
		Conta cc1 = new ContaCorrente(22, 33);
		Cliente clienteCC1 = new Cliente("Nico", "333.222.111-40");
		cc1.setTitular(clienteCC1);
		cc1.deposita(333.0);

		Conta cc2 = new ContaPoupanca(22, 44);
		Cliente clienteCC2 = new Cliente("Guilherme", "222.555.777-33");
		cc2.setTitular(clienteCC2);
		cc2.deposita(444.0);

		Conta cc3 = new ContaCorrente(22, 11);
		Cliente clienteCC3 = new Cliente("Paulo", "300.222.110-34");
		cc3.setTitular(clienteCC3);
		cc3.deposita(111.0);

		Conta cc4 = new ContaPoupanca(22, 22);
		Cliente clienteCC4 = new Cliente("Ana", "456.789.145-67");
		cc4.setTitular(clienteCC4);
		cc4.deposita(222.0);
		
		List<Conta>contas = new ArrayList<Conta>();
		contas.add(cc4);
		contas.add(cc3);
		contas.add(cc2);
		contas.add(cc1);
		
		contas.sort( (c1, c2) -> ( c1.getTitular().getNome().compareTo(c2.getTitular().getNome()) ) );
		/*
		contas.sort( (c1, c2) -> {
            String nomeC1 = c1.getTitular().getNome();
            String nomeC2 = c2.getTitular().getNome();
            return nomeC1.compareTo(nomeC2);
            });
		*/
		contas.forEach((conta) -> System.out.println(conta));
		System.out.println("---------------");
		
		
		contas.sort ( (c1, c2) -> (Integer.compare(c1.getNumero(), c2.getNumero())) );
		
		contas.forEach((conta) -> System.out.println(conta));
	}
}


