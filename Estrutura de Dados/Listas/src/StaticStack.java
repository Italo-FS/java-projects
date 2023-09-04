public class StaticStack<T> implements Stack<T> {
	private T[] stack;
	private int numberOfElements;

	@SuppressWarnings("unchecked")
	public StaticStack(int initialSize) {
		this.stack = (T[]) new Object[initialSize];
		this.numberOfElements = 0;
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
	public T peek() throws EmptyDataStructureException {
		if (isEmpty())
			throw new EmptyDataStructureException();

		T lastElement = this.stack[this.numberOfElements - 1];
		return lastElement;
	}

	@Override
	public T pop() throws EmptyDataStructureException {
		if (isEmpty())
			throw new EmptyDataStructureException();

		T lastElement = this.stack[this.numberOfElements - 1];
		this.stack[this.numberOfElements - 1] = null;
		this.numberOfElements--;
		return lastElement;
	}

	@Override
	public void push(T value) throws FullDataStructureException {
		if (isFull())
			throw new FullDataStructureException();

		this.stack[this.numberOfElements] = value;
		this.numberOfElements++;
	}

	@Override
	public void showElements() throws EmptyDataStructureException {
		System.out.print("[");
		System.out.println(this.numberOfElements);
		for (int i = 0; i < this.numberOfElements; i++) {
			if (i != this.numberOfElements - 1) {
				System.out.print(this.stack[i] + ", ");
			} else {
				System.out.print(this.stack[i]);
			}
		}
		System.out.println("]");
	}

	@Override
	public int size() {
		return this.stack.length;
	}
}