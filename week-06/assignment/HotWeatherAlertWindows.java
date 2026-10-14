import java.util.*;

public class HotWeatherAlertWindows {
    /**
     * Sliding window counting k-sized windows whose average >= threshold.
     * Sum check: sum >= k * threshold avoids floating point division errors.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || readings.length < k || k <= 0) return 0;

        long requiredSum = (long) k * threshold;
        long currentSum = 0;

        // Initial window
        for (int i = 0; i < k; i++) {
            currentSum += readings[i];
        }

        int alerts = 0;
        if (currentSum >= requiredSum) {
            alerts++;
        }

        // Slide window
        for (int i = k; i < readings.length; i++) {
            currentSum += readings[i] - readings[i - k];
            if (currentSum >= requiredSum) {
                alerts++;
            }
        }

        return alerts;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        System.out.println("Alerts: " + countAlerts(readings, k, threshold));
    }
}
