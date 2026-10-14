import java.util.*;

public class PopularCanteenOrder {
    public static class OrderSummary {
        public final String item;
        public final int count;
        public OrderSummary(String item, int count) {
            this.item = item;
            this.count = count;
        }
        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    /**
     * Finds most popular item. Ties broken by first appearance in orders list.
     * Time Complexity: O(N) using HashMap
     * Space Complexity: O(U) where U is number of unique items
     */
    public static OrderSummary mostPopular(List<String> orders) {
        if (orders == null || orders.isEmpty()) return null;

        Map<String, Integer> counts = new HashMap<>();
        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        int maxCount = 0;
        for (int c : counts.values()) {
            if (c > maxCount) maxCount = c;
        }

        // Second pass over original list ensures tie is broken by first appearance
        for (String item : orders) {
            if (counts.get(item) == maxCount) {
                return new OrderSummary(item, maxCount);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> orders = Arrays.asList("dosa", "idli", "vada", "dosa", "idli", "dosa", "tea");
        System.out.println("Result: " + mostPopular(orders));
    }
}
