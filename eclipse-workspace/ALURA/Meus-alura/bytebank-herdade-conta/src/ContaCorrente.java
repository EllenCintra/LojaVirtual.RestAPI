public class ContaCorrente extends Conta {

	public ContaCorrente(int agencia, int numero, Cliente titular) {
		super(agencia, numero, titular);
	}

	@Override
	public void saca(double valor){
		valor=valor+0.2;
		super.saca(valor);
	}
}
