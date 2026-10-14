import java.util.*;

public class MergeTokenQueues {
    /**
     * Merges two ascending sorted lists into one sorted list using two pointers.
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n) for the merged output list
     */
    public static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int nA = counterA.size();
        int nB = counterB.size();

        while (i < nA && j < nB) {
            if (counterA.get(i) <= counterB.get(j)) {
                result.add(counterA.get(i));
                i++;
            } else {
                result.add(counterB.get(j));
                j++;
            }
        }

        while (i < nA) {
            result.add(counterA.get(i));
            i++;
        }

        while (j < nB) {
            result.add(counterB.get(j));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(3, 8, 15, 20);
        List<Integer> b = Arrays.asList(5, 8, 12);
        System.out.println("Merged: " + mergeTokens(a, b));
    }
}
