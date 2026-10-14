import java.util.*;

public class PairWithTargetSum {
    /**
     * Checks if two distinct elements sum up to target using Hash Set.
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println("Target 9: " + hasPairWithSum(nums1, 9));
        int[] nums2 = {3, 4, 6};
        System.out.println("Target 20: " + hasPairWithSum(nums2, 20));
    }
}
