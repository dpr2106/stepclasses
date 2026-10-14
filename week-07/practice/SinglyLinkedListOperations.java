public class SinglyLinkedListOperations {
    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public boolean deleteByValue(int val) {
        if (head == null) return false;
        if (head.val == val) {
            head = head.next;
            return true;
        }
        Node curr = head;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public boolean search(int val) {
        Node curr = head;
        while (curr != null) {
            if (curr.val == val) return true;
            curr = curr.next;
        }
        return false;
    }

    public int findMiddle() {
        if (head == null) throw new IllegalStateException("Empty list");
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {
        SinglyLinkedListOperations list = new SinglyLinkedListOperations();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Search 30: " + list.search(30));
        System.out.println("Middle element: " + list.findMiddle());
        list.deleteByValue(30);
        System.out.println("Search 30 after deletion: " + list.search(30));
    }
}
