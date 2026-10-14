import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 25};
        System.out.println("NGE: " + Arrays.toString(nextGreaterElements(nums)));
    }
}
