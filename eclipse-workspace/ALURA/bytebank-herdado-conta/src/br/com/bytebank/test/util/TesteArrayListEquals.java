package br.com.bytebank.test.util;

import br.com.bytebank.banco.Modelo.Conta;
import br.com.bytebank.banco.Modelo.ContaCorrente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


public class TesteArrayListEquals {

	public static void main(String[] args){
		
		
	    List<Conta> lista = new Vector<Conta>();

	    Conta cc1 = new ContaCorrente(22, 22);
	    Conta cc2 = new ContaCorrente(22, 22);

	    lista.add(cc1);
	    
	     
	    boolean existe = lista.contains(cc2);
	    System.out.println("Já existe?" + existe);
	    
	    for(Conta conta : lista){
	    System.out.println(conta);
	    
	    }
	    
	}
}
