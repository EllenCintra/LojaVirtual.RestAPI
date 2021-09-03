package br.com.bytebank.banco.Modelo;

public class GuardadorDeContas {

	private Conta[] referencias;
	private int posicaoLivre;
	
	public GuardadorDeContas() {
		this.referencias = new Conta[10];
	}

	public void adiciona(Conta ref) {
		referencias[this.posicaoLivre] = ref;
		this.posicaoLivre++;
	}

	public int getQuantidadeDeElementos() {
		return this.posicaoLivre;
	}

	public Conta getReferencia(int ref) {
		return referencias[ref];
	}
	
}
