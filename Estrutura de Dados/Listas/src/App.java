public class App {
	public static void main(String[] args) throws Exception {
		StaticStack<Integer> stack = new StaticStack<Integer>(5);

		stack.showElements();
		stack.push(1);
		stack.showElements();
		stack.push(2);
		stack.showElements();
		stack.push(3);
		stack.showElements();
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		stack.showElements();

		System.out.println();
		System.out.println("============================");
		System.out.println();

		StaticQueue<Integer> queue = new StaticQueue<Integer>(5);

		queue.showElements();
		queue.enqueue(1);
		queue.showElements();
		queue.enqueue(2);
		queue.showElements();
		queue.enqueue(3);
		queue.showElements();
		System.out.println(queue.first());
		System.out.println(queue.dequeue());
		queue.showElements();
	}
}