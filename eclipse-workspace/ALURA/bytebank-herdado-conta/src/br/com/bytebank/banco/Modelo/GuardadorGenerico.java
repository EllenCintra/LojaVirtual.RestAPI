package br.com.bytebank.banco.Modelo;

public class GuardadorGenerico {

	private Object[] referencias;
	private int posicaoLivre;
	
	public GuardadorGenerico() {
		this.referencias = new Object[10];
	}

	public void adiciona(Object ref) {
		referencias[this.posicaoLivre] = ref;
		this.posicaoLivre++;
	}

	public int getQuantidadeDeElementos() {
		return this.posicaoLivre;
	}

	public Object getReferencia(int ref) {
		return referencias[ref];
	}
	
}
