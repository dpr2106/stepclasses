public class WarehouseGridSummary {
    public static class Summary {
        public final int totalItems;
        public final int maxRow;
        public final int maxCol;
        public Summary(int total, int r, int c) {
            this.totalItems = total;
            this.maxRow = r;
            this.maxCol = c;
        }
        @Override
        public String toString() {
            return "(" + totalItems + ", (" + maxRow + ", " + maxCol + "))";
        }
    }

    /**
     * Calculates total items and coordinate of first bin with maximum items.
     * Time Complexity: O(m * n)
     * Space Complexity: O(1)
     */
    public static Summary warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int bestRow = 0;
        int bestCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    bestRow = r;
                    bestCol = c;
                }
            }
        }
        return new Summary(total, bestRow, bestCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        System.out.println(warehouseSummary(grid));
    }
}
