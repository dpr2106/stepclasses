import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static class ArrayEntry implements Comparable<ArrayEntry> {
        public int val, arrayIndex, elementIndex;
        public ArrayEntry(int val, int aIdx, int eIdx) {
            this.val = val;
            this.arrayIndex = aIdx;
            this.elementIndex = eIdx;
        }
        @Override
        public int compareTo(ArrayEntry other) {
            return Integer.compare(this.val, other.val);
        }
    }

    public static int[] mergeK(int[][] arrays) {
        PriorityQueue<ArrayEntry> pq = new PriorityQueue<>();
        int totalElements = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                pq.offer(new ArrayEntry(arrays[i][0], i, 0));
                totalElements += arrays[i].length;
            }
        }

        int[] result = new int[totalElements];
        int idx = 0;
        while (!pq.isEmpty()) {
            ArrayEntry curr = pq.poll();
            result[idx++] = curr.val;
            if (curr.elementIndex + 1 < arrays[curr.arrayIndex].length) {
                pq.offer(new ArrayEntry(arrays[curr.arrayIndex][curr.elementIndex + 1], curr.arrayIndex, curr.elementIndex + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arrs = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        System.out.println("Merged K: " + java.util.Arrays.toString(mergeK(arrs)));
    }
}
