package teste;

public class teste {

	public static void main(String[] args) {

		int altura = 5;
		double qtdetraco = altura - 1;
		String linha = "";
		String traco = "";
		String hash = "#";

		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < qtdetraco; j++) {
				traco = traco.concat("-");
			}
			
			linha = traco.concat(hash).concat(traco);
			System.out.println(linha);
			
			qtdetraco-=1;
			traco="";
			hash=hash.concat("##");
		}
	}
}
