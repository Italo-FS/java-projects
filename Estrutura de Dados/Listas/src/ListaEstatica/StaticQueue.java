package ListaEstatica;

public class StaticQueue<T> implements Queue<T> {
	private T[] queue;
	private int numberOfElements;

	@SuppressWarnings("unchecked")
	public StaticQueue(int initialSize) {
		this.queue = (T[]) new Object[initialSize];
		this.numberOfElements = 0;
	}

	@Override
	public T dequeue() throws EmptyDataStructureException {
		if (isEmpty())
			throw new EmptyDataStructureException();

		T fisrtElement = this.queue[0];

		for (int i = 0; i < this.numberOfElements - 1; i++) {
			this.queue[i] = this.queue[i + 1];
		}
		this.numberOfElements--;
		return fisrtElement;
	}

	@Override
	public void enqueue(T value) throws FullDataStructureException {
		if (isFull())
			throw new FullDataStructureException();

		this.queue[this.numberOfElements] = value;
		this.numberOfElements++;
	}

	@Override
	public T first() throws EmptyDataStructureException {
		if (isEmpty())
			throw new EmptyDataStructureException();

		T lastElement = this.queue[0];
		return lastElement;
	}

	@Override
	public boolean isEmpty() {
		return this.numberOfElements == 0;
	}

	@Override
	public boolean isFull() {
		return this.numberOfElements == this.size();
	}

	@Override
	public void showElements() throws EmptyDataStructureException {
		System.out.print("[");
		for (int i = 0; i < this.numberOfElements; i++) {
			if (i != this.numberOfElements - 1) {
				System.out.print(this.queue[i] + ", ");
			} else {
				System.out.print(this.queue[i]);
			}
		}
		System.out.println("]");
	}

	@Override
	public int size() {
		return this.queue.length;
	}
}