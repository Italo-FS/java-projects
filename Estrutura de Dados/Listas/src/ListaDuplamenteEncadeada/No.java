package ListaDuplamenteEncadeada;

class No<T> {
	T valor;
	No<T> proximo;
	No<T> anterior;

	public No(T valor) {
		this.valor = valor;
	}
}