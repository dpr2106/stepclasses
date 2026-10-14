import java.util.PriorityQueue;

public class KthLargestElement {
    /**
     * Finds the kth largest element in an unsorted array using a Min-Heap of size k.
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println("2nd Largest: " + findKthLargest(nums, 2));
    }
}
