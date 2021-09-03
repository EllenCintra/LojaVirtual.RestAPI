public class TesteContas {

	    public static void main(String[] args) { 
	        
	    	Cliente paulo = new Cliente ("Paulo", "444.222.333-40", "Programador");
	    	Conta ccDoPaulo = new ContaCorrente(2166, 01, paulo);
	    	Conta cpDoPaulo = new ContaPoupanca(2166, 01, paulo);
	               
	    	ccDoPaulo.deposita(150);
	        System.out.println("Depósito em Conta Corrente realizado com sucesso! Ver saldo: " + ccDoPaulo.getSaldo());
	        
	        cpDoPaulo.deposita(150);
	        System.out.println("Depósito em Conta Poupança realizado com sucesso! Ver saldo: " + cpDoPaulo.getSaldo());
	        
	        
	        
	        Cliente marcela = new Cliente ("Marcela", "333.111.555-77", "Comerciante");
	    	Conta ccDaMarcela = new ContaCorrente(2166, 02, marcela);
	    	Conta cpDaMarcela = new ContaPoupanca (2166, 02, marcela);
	        System.out.println("Total de contas criadas: " + Conta.getTotalContas());
	        System.out.println("Bem-vinda, " + marcela.getNome() +"!");
	        
	        ccDaMarcela.deposita(1000);
	        System.out.println("Depósito em Conta Corrente realizado com sucesso! Ver saldo: " + ccDaMarcela.getSaldo());
	        	        ccDaMarcela.transfere(300, ccDoPaulo); 
	        System.out.println("Ver saldo: : " + ccDaMarcela.getSaldo());
	        	        ccDaMarcela.saca(700);
	        System.out.println("Ver saldo: : " + ccDaMarcela.getSaldo());
	        
	        cpDaMarcela.deposita(100);
	        System.out.println("Depósito em Conta Poupança realizado com sucesso! Ver saldo: : "+ cpDaMarcela.getSaldo());      
	        cpDaMarcela.transfere(100, ccDoPaulo);
	        System.out.println("Ver saldo: : " + cpDaMarcela.getSaldo());
	        

	        System.out.println("Bem-vindo, " + ccDoPaulo.getTitular().getNome() +"!");
	        System.out.println("Ver saldo: : " + ccDoPaulo.getSaldo());
	        ccDoPaulo.saca(450);
	        System.out.println("Saque realizado com sucesso. Ver saldo: : " + ccDoPaulo.getSaldo());
	        System.out.println("Saldo da CP: " + cpDoPaulo.getSaldo());
	        
	       /* Conta Ellen = new Conta (); Exemplo de que o construtor padrão, automático do java, é válido e utilizável quando o programador não define um construtor para o objeto.
	        * Nesse caso, o java "cria" um para você.*/
	    }
	}
