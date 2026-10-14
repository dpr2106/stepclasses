public class CustomMinHeap {
    private int[] heap;
    private int size;

    public CustomMinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int val) {
        if (size == heap.length) throw new IllegalStateException("Heap full");
        heap[size] = val;
        swim(size++);
    }

    public int extractMin() {
        if (size == 0) throw new IllegalStateException("Heap empty");
        int min = heap[0];
        heap[0] = heap[--size];
        sink(0);
        return min;
    }

    private void swim(int k) {
        while (k > 0 && heap[k] < heap[(k - 1) / 2]) {
            swap(k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        while (2 * k + 1 < size) {
            int j = 2 * k + 1;
            if (j + 1 < size && heap[j + 1] < heap[j]) j++;
            if (heap[k] <= heap[j]) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        int t = heap[i]; heap[i] = heap[j]; heap[j] = t;
    }

    public static void main(String[] args) {
        CustomMinHeap h = new CustomMinHeap(10);
        h.insert(15); h.insert(10); h.insert(30); h.insert(5);
        System.out.println("Extract Min: " + h.extractMin());
        System.out.println("Extract Min: " + h.extractMin());
    }
}
