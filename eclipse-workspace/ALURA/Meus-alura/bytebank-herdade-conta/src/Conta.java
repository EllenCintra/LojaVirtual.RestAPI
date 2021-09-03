public abstract class Conta{

	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	
	private static int totalContas = 0;
	
	public Conta(int agencia, int numero, Cliente titular) { /*Construtor de um objeto CONTA. O construtor tem sempre o mesmo nome da classe e, diferente de um m�todo, 
	ele n�o retorna nada. o "new Conta (); seria o construtor padr�o do Java, onde n�o � passado nenhum parametro. Logo, os atributos do objeto assumem o valor default.
	Podemos adicionar v�rios construtores na classe, desde que eles difiram na quantidade ou tipo de par�metros.*/
		
		this.saldo = 0;
		this.agencia = agencia;
		this.numero = numero;
		this.titular = titular;
		
		System.out.println(this.getTitular().getNome() + ", sua conta foi criada com sucesso!");
		
		totalContas++;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public double getSaldo () {
    		return saldo;
     }
    
    public void mensagemSaldoInsufiente () {
    	System.out.println("N�o h� saldo suficiente");
    }
    
    public void deposita(double valor){
    	this.saldo += valor;
    }
    
    public void saca(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
        } else {
        	mensagemSaldoInsufiente();
        }
    }
    
    public void transfere(double valor, Conta destino){
        if(this.saldo >= valor){
            this.saca(valor);
            destino.deposita(valor); 
            System.out.println("Transfer�ncia realizada com sucesso");
        }
        else {
        	mensagemSaldoInsufiente();
        }
        
    }

	public static int getTotalContas() {
		return totalContas;
	}

    
}

