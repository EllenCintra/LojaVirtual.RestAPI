package bitebank;

public class TestaMetodo {

	    public static void main(String[] args) { 
	        Cliente paulo = new Cliente ("Paulo", "444.222.333-40", "Programador");
	    	Conta contaDoPaulo = new Conta(2166, 01, paulo);
	    	System.out.println("Total de contas criadas: " + Conta.getTotalContas());
	        
	    	System.out.println("Bem-vindo, " + paulo.getNome() +"! Sua ag�ncia � " + contaDoPaulo.getAgencia() + " e o n�mero da sua conta � " + contaDoPaulo.getNumero());
	        
	    	contaDoPaulo.deposita(150);
	        System.out.println("Dep�sito realizado com sucesso! Ver saldo");
	        contaDoPaulo.getSaldo(true);
	        
	        Cliente marcela = new Cliente ("Marcela", "333.111.555-77", "Comerciante");
	    	Conta contaDaMarcela = new Conta(2166, 02, marcela);
	        System.out.println("Total de contas criadas: " + Conta.getTotalContas());
	        
	        System.out.println("Bem-vinda, " + marcela.getNome() +"!");
	        
	        contaDaMarcela.deposita(1000);
	        System.out.println("Dep�sito realizado com sucesso! Ver saldo");
	        contaDaMarcela.getSaldo(true);
	        
	        contaDaMarcela.transfere(300, contaDoPaulo); 
	        System.out.println("Ver saldo");
	        contaDaMarcela.getSaldo(true);
	        
	        contaDaMarcela.saca(700);
	        System.out.println("Saque realizado com sucesso. Ver saldo");
	        contaDaMarcela.getSaldo(true);
	        
	        contaDaMarcela.transfere(50, contaDoPaulo);
	        System.out.println("A transfer�ncia n�o p�de ser realizada");
	        
	        System.out.println("Bem-vindo, " + contaDoPaulo.getTitular().getNome() +"!");
	        System.out.println("Ver saldo");
	        contaDoPaulo.getSaldo(true);
	        contaDoPaulo.saca(450);
	        System.out.println("Saque realizado com sucesso. Ver saldo");
	        contaDoPaulo.getSaldo(true);
	        
	       /* Conta Ellen = new Conta (); Exemplo de que o construtor padr�o, autom�tico do java, � v�lido e utiliz�vel quando o programador n�o define um construtor para o objeto.
	        * Nesse caso, o java "cria" um para voc�.*/
	    }
	}


