package ListaDinamica;

public class ListaEncadeadaSimples<T> {
	private No<T> inicio;
	private No<T> fim;
	private int tamanho;

	public ListaEncadeadaSimples() {
		tamanho = 0;
		inicio = null;
		fim = null;
	}

	public ListaEncadeadaSimples(T valor) {
		No<T> novoNo = new No<T>(valor);
		inicio = novoNo;
		fim = novoNo;
		tamanho = 1;
	}

	public T retornaValor(int posicao) {
		return retornaNo(posicao).valor;
	}

	private No<T> retornaNo(int posicao) {
		if (inicio == null) {
			throw new RuntimeException("Lista está vazia!");
		} else if (posicao < 0 || posicao >= tamanho) {
			throw new IndexOutOfBoundsException("posição " + posicao + " está fora dos limites da lista");
		}
		No<T> noAuxiliar = inicio;
		for (int i = 0; i < posicao; i++) {
			noAuxiliar = noAuxiliar.proximo;
		}
		return noAuxiliar;

	}

	public void inserirInicio(T valor) {
		No<T> novoNo = new No<T>(valor);
		if (inicio == null) {
			inicio = novoNo;
			fim = novoNo;
		} else {
			novoNo.proximo = inicio;
			inicio = novoNo;
		}
		tamanho++;

	}

	public void inserirFim(T valor) {
		No<T> novoNo = new No<T>(valor);
		if (inicio == null) {
			inicio = novoNo;
		} else {
			fim.proximo = novoNo;
		}
		fim = novoNo;
		tamanho++;
	}

	public void inserirPosicao(int posicao, T valor) {
		if (posicao <= 0) {
			inserirInicio(valor);
		} else if (posicao >= tamanho) {
			inserirFim(valor);
		} else {
			No<T> novoNo = new No<T>(valor);
			No<T> noAuxiliar = retornaNo(posicao - 1);
			novoNo.proximo = noAuxiliar.proximo;
			noAuxiliar.proximo = novoNo;
			tamanho++;
		}

	}

	public void exibirLista() {
		System.out.print("[");
		No<T> noAuxiliar = inicio;
		while (noAuxiliar != null) {
			System.out.print(noAuxiliar.valor);
			noAuxiliar = noAuxiliar.proximo;
			if (noAuxiliar != null) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	public void excluirInicio() {
		if (inicio == null)
			throw new RuntimeException("Lista está vazia!");
		No<T> noAuxiliar = inicio;
		inicio = inicio.proximo;
		noAuxiliar.proximo = null;
		tamanho--;
	}

	public void excluirFinal() {
		if (inicio == null)
			throw new RuntimeException("Lista está vazia!");
		fim = retornaNo(tamanho - 2);
		fim.proximo = null;
		tamanho--;
	}

	public void excluirPosicao(int posicao) {
		if (inicio == null)
			throw new RuntimeException("Lista está vazia!");
		if (posicao < 0 || posicao >= tamanho)
			throw new IndexOutOfBoundsException("posição " + posicao + " está fora dos limites da lista");
		if (posicao == 0) {
			excluirInicio();
		} else if (posicao == tamanho - 1) {
			excluirFinal();
		} else {
			No<T> noAuxiliarAnterior = retornaNo(posicao - 1);
			No<T> noAuxiliarMarcadoDeMorte = noAuxiliarAnterior.proximo;
			noAuxiliarAnterior.proximo = noAuxiliarMarcadoDeMorte.proximo;
			noAuxiliarMarcadoDeMorte.proximo = null;
			tamanho--;
		}
	}
}