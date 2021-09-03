package br.com.alura.bytebank;

import br.com.bytebank.banco.Modelo.Conta;
import br.com.bytebank.banco.Modelo.ContaCorrente;

public class TesteBiblioteca {

    public static void main(String[] args) {
        Conta c = new ContaCorrente(123, 321);
    }
}