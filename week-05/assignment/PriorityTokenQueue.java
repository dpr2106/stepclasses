public class PriorityTokenQueue {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public PriorityTokenQueue() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Inserts token at the front (priority).
     * Time Complexity: O(1)
     */
    public void addFirst(int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Inserts token at the end (normal).
     * Time Complexity: O(n) - or O(1) if maintaining tail reference
     */
    public void addLast(int token) {
        Node newNode = new Node(token);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    /**
     * Inserts token at specified 0-based index (rescheduled).
     * Time Complexity: O(index) <= O(n)
     */
    public void insertAt(int index, int token) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            addFirst(token);
            return;
        }
        if (index == size) {
            addLast(token);
            return;
        }

        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        Node newNode = new Node(token);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        PriorityTokenQueue queue = new PriorityTokenQueue();
        queue.addLast(101);
        queue.addLast(102);
        queue.addLast(103);
        System.out.print("Start: ");
        queue.printList();

        queue.addFirst(100);
        queue.addLast(104);
        queue.insertAt(2, 150);

        System.out.print("Expected: 100 -> 101 -> 150 -> 102 -> 103 -> 104 -> null\nActual:   ");
        queue.printList();
    }
}
