package ListaEstatica;

interface Stack<T> {
	public int size();

	public boolean isEmpty();

	public boolean isFull();

	public void push(T value) throws FullDataStructureException;

	public T pop() throws EmptyDataStructureException;

	public T peek() throws EmptyDataStructureException;

	public void showElements() throws EmptyDataStructureException;
}