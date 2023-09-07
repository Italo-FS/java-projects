package ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada<T> {
	private No<T> inicio;
	private No<T> fim;
	private int tamanho;

	public ListaDuplamenteEncadeada() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}

	public ListaDuplamenteEncadeada(T valor) {
		inserirPrimeiroNo(valor);
	}

	public void exibirLista() {
		No<T> noAux = inicio;
		System.out.print("[");
		while (noAux != null) {
			System.out.print(noAux.valor);
			if (noAux.proximo != null)
				System.out.print(", ");
			noAux = noAux.proximo;
		}
		System.out.println("]");
	}

	private void inserirPrimeiroNo(T valor) {
		No<T> novoNo = new No<T>(valor);
		inicio = novoNo;
		fim = novoNo;
	}

	private No<T> retornaNo(int posicao) {
		if (posicao < 0 || posicao >= tamanho) {
			throw new IndexOutOfBoundsException("Posição " + posicao + " está fora dos limites.");
		}
		No<T> noAux = inicio;
		boolean comecarDoInicio = (posicao < tamanho / 2);
		for (int i = comecarDoInicio ? 0 : tamanho - 1; i < posicao; i = i + (comecarDoInicio ? 1 : -1)) {
			noAux = noAux.proximo;
		}
		return noAux;
	}

	public void inserirInicio(T valor) {
		if (inicio == null) {
			inserirPrimeiroNo(valor);
		} else {
			No<T> novoNo = new No<T>(valor);
			novoNo.proximo = inicio;
			inicio.proximo = novoNo;
			inicio = novoNo;
		}
		tamanho++;
	}

	public void inserirFim(T valor) {
		if (fim == null) {
			inserirPrimeiroNo(valor);
		} else {
			No<T> novoNo = new No<T>(valor);
			novoNo.anterior = fim;
			fim.proximo = novoNo;
			fim = novoNo;
		}
		tamanho++;
	}

	public void inserirPosicao(int posicao, T valor) {
		if (posicao <= 0) {
			inserirInicio(valor);
		} else if (posicao >= tamanho) {
			inserirFim(valor);
		} else {
			No<T> novoNo = new No<T>(valor);
			novoNo.anterior = retornaNo(posicao - 1);
			novoNo.proximo = novoNo.anterior.proximo;
			novoNo.anterior.proximo = novoNo;
			novoNo.proximo.anterior = novoNo;
		}
	}

	public void removerUnico() {
		if (tamanho == 1) {
			inicio = null;
			fim = null;
			tamanho = 0;
		}
	}

	public void removerInicio() {
		if (tamanho == 1)
			removerUnico();
		else {
			inicio = inicio.proximo;
			inicio.anterior.proximo = null;
			inicio.anterior = null;
			tamanho--;
		}
	}

	public void removerFim() {
		if (tamanho == 1)
			removerUnico();
		else {
			fim = fim.anterior;
			fim.proximo.anterior = null;
			fim.proximo = null;
			tamanho--;
		}
	}

	public void removerPosicao(int posicao) {
		if (posicao == 0)
			removerInicio();
		else if (posicao == tamanho - 1)
			removerFim();
		else {
			No<T> noAux = retornaNo(posicao);
			noAux.anterior.proximo = noAux.proximo;
			noAux.proximo.anterior = noAux.anterior;
			noAux.anterior = null;
			noAux.proximo = null;
			tamanho--;
		}
	}

}
