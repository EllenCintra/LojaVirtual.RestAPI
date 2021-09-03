package br.com.bytebank.test.util;

import br.com.bytebank.banco.Modelo.Conta;
import br.com.bytebank.banco.Modelo.ContaCorrente;
import br.com.bytebank.banco.Modelo.ContaPoupanca;

public class TestArrayReferencias {

	public static void main(String[] args) {

		Conta[] contas = new Conta[5];
        ContaCorrente cc1 = new ContaCorrente(24, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(23, 22);
        contas[1] = cc2;    

        ContaPoupanca ref = (ContaPoupanca) contas[1];
        System.out.println(ref.getNumero());
        System.out.println(contas[0].getNumero());
        
        System.out.println(contas[1].getNumero());
        System.out.println(cc2.getNumero());

	}

}
