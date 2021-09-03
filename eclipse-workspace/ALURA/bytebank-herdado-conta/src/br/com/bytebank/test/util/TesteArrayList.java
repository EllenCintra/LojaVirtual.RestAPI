package br.com.bytebank.test.util;

import br.com.bytebank.banco.Modelo.Conta;
import br.com.bytebank.banco.Modelo.ContaCorrente;
import br.com.bytebank.banco.Modelo.GuardadorDeContas;
import br.com.bytebank.banco.Modelo.GuardadorGenerico;
import br.com.bytebank.banco.Modelo.Cliente;


public class TesteArrayList {

	public static void main(String[] args) {
		GuardadorDeContas guardador = new GuardadorDeContas();
		
		Conta cc1 = new ContaCorrente(22,11);
		guardador.adiciona(cc1);
		
		Conta cc2 = new ContaCorrente(22,12);
		guardador.adiciona(cc2);
		
		int tamanho = guardador.getQuantidadeDeElementos();
		System.out.println(tamanho);
		
		Conta ref = guardador.getReferencia(0);
		System.out.println(ref.getNumero());
		
		GuardadorGenerico guardadorGenerico = new GuardadorGenerico();
		
		Cliente cl1 = new Cliente("Ellen", "444.333.222-11");
		guardadorGenerico.adiciona(cl1);
		cc1.setTitular(cl1);
		guardadorGenerico.adiciona(cc1);
		
		Cliente cl2 = new Cliente("Erika", "434.323.212-10");
		guardadorGenerico.adiciona(cl2);
		cc2.setTitular(cl2);
		guardadorGenerico.adiciona(cc2);
		
		int tamanhoGuardGenerico = guardadorGenerico.getQuantidadeDeElementos();
		System.out.println(tamanhoGuardGenerico);
		
	
	}
}
