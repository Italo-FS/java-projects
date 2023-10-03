package ListaPrioridade;

public class App {
    public static void main(String[] args) throws Exception {
        SortedPriorityQueue uSortedPriorityQueue = new SortedPriorityQueue();
        uSortedPriorityQueue.insert(1, "Paulo");
        uSortedPriorityQueue.insert(0, "Drakson");
        uSortedPriorityQueue.insert(1, "Ana Clara");
        uSortedPriorityQueue.insert(0, "Matheus");
        uSortedPriorityQueue.insert(3, "J. August");
        uSortedPriorityQueue.insert(2, "Bruno");
        uSortedPriorityQueue.insert(2, "Felipe");
        uSortedPriorityQueue.insert(2, "Carlos");
        uSortedPriorityQueue.insert(0, "Nikely");
        uSortedPriorityQueue.insert(-1, "Caio");
        uSortedPriorityQueue.insert(0, "Nicole");
        uSortedPriorityQueue.insert(-1, "Italo");

        uSortedPriorityQueue.removeMin();
        uSortedPriorityQueue.removeMin();
        uSortedPriorityQueue.removeMin();
        uSortedPriorityQueue.removeMin();
        uSortedPriorityQueue.removeMin();
        uSortedPriorityQueue.removeMin();
        uSortedPriorityQueue.removeMin();
        uSortedPriorityQueue.removeMin();
        uSortedPriorityQueue.removeMin();
        uSortedPriorityQueue.printQueue();
    }
}