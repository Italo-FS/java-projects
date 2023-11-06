import java.util.Scanner;

public class B1259 {
    public static void main(String[] args) {
        MinHeap even = new MinHeap();
        MaxHeap odd = new MaxHeap();

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int inputsNumber = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < inputsNumber; i++) {
            int inputValue = Integer.parseInt(sc.nextLine());

            if (isEven(inputValue)) {
                even.push(inputValue);
            } else {
                odd.push(inputValue);
            }
        }
        sc.close();

        sb.append(even.chop());
        sb.append(odd.chop());

        System.out.println(sb);
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static class MaxHeap extends Heap {
        @Override
        public void swim(TreeNode node) {
            while (node.parent != null && node.value > node.parent.value) {
                swap(node, node.parent);
                node = node.parent;
            }
        }

        @Override
        public void sink(TreeNode node) {
            while (true) {
                TreeNode biggest = node;
                if (node.left != null && node.left.value > biggest.value) {
                    biggest = node.left;
                }
                if (node.right != null && node.right.value > biggest.value) {
                    biggest = node.right;
                }
                if (biggest != node) {
                    swap(node, biggest);
                    node = biggest;
                } else {
                    break;
                }
            }
        }

    }

    public static class MinHeap extends Heap {
        @Override
        public void swim(TreeNode node) {
            while (node.parent != null && node.value < node.parent.value) {
                swap(node, node.parent);
                node = node.parent;
            }
        }

        @Override
        public void sink(TreeNode node) {
            while (true) {
                TreeNode smallest = node;
                if (node.left != null && node.left.value < smallest.value) {
                    smallest = node.left;
                }
                if (node.right != null && node.right.value < smallest.value) {
                    smallest = node.right;
                }
                if (smallest != node) {
                    swap(node, smallest);
                    node = smallest;
                } else {
                    break;
                }
            }
        }
    }

    public static abstract class Heap {
        TreeNode root;
        int size;

        protected void insertFirstNode(int value) {
            if (root != null)
                throw new RuntimeException("A lista deve estar vazia para executar 'insertFirstNode()'.");
            TreeNode newNode = new TreeNode(value);
            root = newNode;
            size++;
        }

        public void push(int value) {
            if (root == null)
                insertFirstNode(value);
            else {
                TreeNode newNode = new TreeNode(value);
                TreeNode newNodeParent = getNode(getParentIndex(size));
                if (isEven(size)) {
                    newNodeParent.right = newNode;
                } else {
                    newNodeParent.left = newNode;
                }
                newNode.parent = newNodeParent;
                size++;
                swim(newNode);
            }
        }

        public Stack getNodeAddressStack(int index) {
            Stack address = new Stack();
            while (index > 0) {
                address.push(index);
                index = getParentIndex(index);
            }
            return address;
        }

        public TreeNode getNodeByAddress(Stack address) {
            TreeNode auxNode = root;
            do {
                int index = address.pop();
                auxNode = isEven(index) ? auxNode.right : auxNode.left;
                if (auxNode == null)
                    throw new RuntimeException("O nó procuardo não existe.");
            } while (address.size > 0);
            return auxNode;
        }

        public TreeNode getNode(int index) {
            checkIfIndexOutOfBounds(index);
            if (index == 0)
                return root;
            Stack address = getNodeAddressStack(index);
            TreeNode auxNode = getNodeByAddress(address);
            return auxNode;
        }

        public TreeNode removeRoot() {
            if (root == null) {
                throw new IllegalStateException("Heap vazio, impossível remover.");
            }
            TreeNode auxNode;
            TreeNode lastNode = getNode(size - 1);

            if (lastNode != root) {
                swap(root, lastNode);
                if (lastNode.parent != null) {
                    if (lastNode.parent.left == lastNode) {
                        lastNode.parent.left = null;
                    } else {
                        lastNode.parent.right = null;
                    }
                }
                auxNode = lastNode;
                size--;
                sink(root);
            } else {
                auxNode = root;
                root = null;
                size--;
            }
            return auxNode;
        }

        public void swap(TreeNode nodeA, TreeNode nodeB) {
            int tempValue = nodeA.value;
            nodeA.value = nodeB.value;
            nodeB.value = tempValue;
        }

        public String chop() {
            StringBuilder sb = new StringBuilder();
            while (root != null) {
                int value = removeRoot().value;
                sb.append(value);
                sb.append("\n");
            }
            return sb.toString();
        }

        public abstract void swim(TreeNode node);

        public abstract void sink(TreeNode node);

        public static int getLeftSonIndex(int index) {
            return index * 2 + 1;
        }

        public static int getRightSonIndex(int index) {
            return index * 2 + 2;
        }

        public static int getParentIndex(int index) {
            return (index - 1) / 2;
        }

        private void checkIfIndexOutOfBounds(int index) {
            if (index < 0 || index > size - 1)
                throw new IndexOutOfBoundsException("O índice " + index + " pesquisado não existe.");
        }

    }

    public static class Stack {
        int size;
        StackNode top;
        StackNode bottom;

        private void insertFirstNode(int value) {
            if (top != null)
                throw new RuntimeException("A lista deve estar vazia para executar 'insertFirstNode()'.");
            StackNode newNode = new StackNode(value);
            top = newNode;
            bottom = newNode;
            size++;
        }

        public void push(int value) {
            if (top == null)
                insertFirstNode(value);
            else {
                StackNode newNode = new StackNode(value);
                top.above = newNode;
                newNode.bellow = top;
                top = newNode;
                size++;
            }
        }

        public Integer pop() {
            if (top == null)
                return null;
            StackNode auxNode = top;
            top = auxNode.bellow;
            if (top != null)
                top.above = null;
            auxNode.bellow = null;
            size--;
            return auxNode.value;
        }
    }

    public static class TreeNode {
        int value;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static class StackNode {
        int value;
        StackNode above;
        StackNode bellow;

        public StackNode(int value) {
            this.value = value;
        }
    }
}
