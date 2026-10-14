public class ReverseQueueList {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Reverses the singly linked list in place using three pointers.
     * Constraints: No new nodes created.
     * Time Complexity: O(N) - single pass through list
     * Additional Space Complexity: O(1) - constant space pointer references
     */
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next; // save next node
            curr.next = prev;         // reverse link
            prev = curr;              // advance prev
            curr = nextNode;          // advance curr
        }

        return prev; // new head
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1: 1 -> 2 -> 3 -> 4
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);

        System.out.print("Sample 1 Input:    ");
        printList(n1);
        Node r1 = reverse(n1);
        System.out.print("Sample 1 Reversed: ");
        printList(r1);

        // Sample 2: 9
        Node n2 = new Node(9);
        System.out.print("Sample 2 Input:    ");
        printList(n2);
        Node r2 = reverse(n2);
        System.out.print("Sample 2 Reversed: ");
        printList(r2);
    }
}
