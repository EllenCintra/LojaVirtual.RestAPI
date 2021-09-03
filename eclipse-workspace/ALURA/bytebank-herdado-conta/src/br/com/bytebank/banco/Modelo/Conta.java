package br.com.bytebank.banco.Modelo;

/**
 * Classe que define uma conta genérica no ByteBank
 * 
 * @author ellen
 * @version 0.1
 *
 */

public abstract class Conta implements Comparable<Conta> {

    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;
    
    /**
     * Construtor para inicializar o objeto Conta a partir da agencia e numero
     * @param agencia
     * @param numero
     */
    public Conta(int agencia, int numero){
        Conta.total++;
        //System.out.println("O total de contas Ã© " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        //this.saldo = 100;
        //System.out.println("Estou criando uma conta " + this.numero);
    }

    public abstract void deposita(double valor);

    /**
     * Valor a sacar precisa ser menor ou igual ao saldo
     * @param valor
     * @return
     */
    public boolean saca(double valor) {
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino) {
        if(this.saca(valor)) {
        		destino.deposita(valor);
        		return true;
        } else {
        		return false;
        }
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }
    
    @Override
    public boolean equals (Object ref) {
    	Conta outra = (Conta) ref;
		
    	if (this.agencia != outra.agencia) {
    	return false;
    	}
    	
    	if (this.numero != outra.numero) {
    		return false;
    	}
    	
    	return true;
       		
    	}
    
    @Override
	public String toString() {
		return this.titular.getNome() + ", Agência: " + this.getAgencia() + " Número: " + this.getNumero();
    }
   
    @Override
	public int compareTo(Conta outra) {
		return Double.compare(this.saldo, outra.saldo);   
	}

}