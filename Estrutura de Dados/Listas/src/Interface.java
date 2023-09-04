interface Queue<T> {
	public int size();

	public boolean isEmpty();

	public boolean isFull();

	public void enqueue(T value) throws FullDataStructureException;

	public T dequeue() throws EmptyDataStructureException;

	public T first() throws EmptyDataStructureException;

	public void showElements() throws EmptyDataStructureException;
}