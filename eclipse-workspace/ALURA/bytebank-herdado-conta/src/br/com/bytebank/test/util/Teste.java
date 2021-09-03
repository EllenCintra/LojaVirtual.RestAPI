package br.com.bytebank.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.Modelo.Conta;
import br.com.bytebank.banco.Modelo.ContaCorrente;
import br.com.bytebank.banco.Modelo.ContaPoupanca;

public class Teste {

	public static void main(String[] args) {
		
		Conta cc1 = new ContaCorrente(22, 33);
		cc1.deposita(333.0);

		Conta cc2 = new ContaPoupanca(22, 44);
		cc2.deposita(444.0);

		Conta cc3 = new ContaCorrente(22, 11);
		cc3.deposita(111.0);

		Conta cc4 = new ContaPoupanca(22, 22);
		cc4.deposita(222.0);

		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);
		
		for (Conta conta : lista) {
		    System.out.println(conta.getNumero());
		}
		System.out.println("---------");
		
		
		NumeroDaContaComparator comparator = new NumeroDaContaComparator();
		lista.sort(comparator);

		for (Conta conta : lista) {
		    System.out.println(conta.getNumero());
		}
		System.out.println("---------");
		
		
		Collections.reverse(lista);
		for (Conta conta : lista) {
		    System.out.println(conta.getNumero());
		}
		System.out.println("---------");
		

		Collections.rotate(lista, 0);
		for (Conta conta : lista) {
		    System.out.println(conta.getNumero());
		}
		System.out.println("---------");
	}
}

class NumeroDaContaComparator implements Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {
    	return Integer.compare(c1.getNumero(), c2.getNumero());
    }
}
