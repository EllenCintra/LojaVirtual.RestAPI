package br.com.bytebank.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.Modelo.Cliente;
import br.com.bytebank.banco.Modelo.Conta;
import br.com.bytebank.banco.Modelo.ContaCorrente;
import br.com.bytebank.banco.Modelo.ContaPoupanca;

public class Teste2 {

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
		
		/**
		 * Não usei o -comparator-, então a classe Conta precisa implementar a interface -Compare- e sobrescrever o método -sort-
		 * Sem fazer o processo acima não é acusado erro pq o parâmetro passado foi null, mas ao tentar executar é lançada a exceção.
		 */
		contas.sort(null);
		
		for (Conta conta : contas) {
			System.out.println(conta);
		}
		System.out.println("---------------");
		
		
		contas.sort(new TitularDaContaComparator()); //já deixando mais enxuto. Como usei o comparator, a classe TitularDaContaComparator precisa implementar a interface Comparator e sobrescrever o método -compare-
		
		for (Conta conta : contas) {
			System.out.println(conta);
		}
		System.out.println("---------------");
		
		
		/**
		 * Método para ordenar a lista contas.
		 * 
		 * Quando invoco o método sort por Collections, preciso especificar através do parâmetro qual lista deverá ser ordenada.
		 * No método acima, só foi passado o comparador pois uma lista especifica que invocou o método, 
		 * já deixando claro que esta é a lista a ser ordenada.
		 * 
		 */
		Collections.sort(contas, new TitularDaContaComparator()); 
		
		for (Conta conta : contas) {
			System.out.println(conta);
		}
		System.out.println("---------------");
		
		
		Collections.sort(contas);//não usei o -comparator-, então a classe Conta precisa implementar a interface -Compare- e sobrescrever o método -sort-
		
		for (Conta conta : contas) {
			System.out.println(conta);
		}
		System.out.println("---------------");
		
		
		Collections.rotate(contas, 3);
		
		for (Conta conta : contas) {
			System.out.println(conta);
		}
	}
}

class TitularDaContaComparator implements Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {
    	String nomeC1 = c1.getTitular().getNome();
    	String nomeC2 = c2.getTitular().getNome();
    	return nomeC1.compareTo(nomeC2);
    }
}
