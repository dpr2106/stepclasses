public class ClassTopperFinder {
    public static class Result {
        public final int rowIndex;
        public final int total;
        public Result(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }
        @Override
        public String toString() {
            return "(" + rowIndex + ", " + total + ")";
        }
    }

    /**
     * Finds the student with highest total marks.
     * Breaks ties by picking smallest row index.
     * Time Complexity: O(m * n) where m = students, n = subjects
     * Additional Space: O(1)
     */
    public static Result findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) return new Result(-1, 0);

        int bestIndex = -1;
        int maxTotal = -1;

        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                currentTotal += marks[i][j];
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestIndex = i;
            }
        }
        return new Result(bestIndex, maxTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };
        Result topper = findTopper(marks);
        System.out.println("Expected: (1, 259), Actual: " + topper);
    }
}
