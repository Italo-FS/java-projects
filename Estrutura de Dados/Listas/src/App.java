import ListaDinamica.ListaEncadeadaSimples;

public class App {
	public static void main(String[] args) throws Exception {
		ListaEncadeadaSimples<Object> lda = new ListaEncadeadaSimples<>();

		lda.inserirFim(1);
		lda.inserirFim(2);
		lda.inserirFim(3);
		lda.inserirFim(4);
		lda.inserirFim(5);
		lda.inserirFim(6);
		lda.inserirFim(7);

		lda.inserirPosicao(2, 30);
		lda.exibirLista();

	}
}