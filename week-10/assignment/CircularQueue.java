public class CircularQueue {
    private final int[] data;
    private int front;
    private int rear;
    private int count;
    private final int capacity;

    public CircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        data[rear] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        count--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);
        System.out.println("enqueue 1: " + q.enQueue(1));
        System.out.println("enqueue 2: " + q.enQueue(2));
        System.out.println("enqueue 3: " + q.enQueue(3));
        System.out.println("enqueue 4 (overflow): " + q.enQueue(4));
        System.out.println("Rear: " + q.Rear());
        System.out.println("isFull: " + q.isFull());
        System.out.println("deQueue: " + q.deQueue());
        System.out.println("enqueue 4: " + q.enQueue(4));
        System.out.println("Rear: " + q.Rear());
    }
}
