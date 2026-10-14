import java.util.*;

public class GraphBFSShortestPath {
    public static int shortestPath(int n, int[][] edges, int start, int target) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(start);
        visited[start] = true;

        int dist = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int node = q.poll();
                if (node == target) return dist;
                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.offer(neighbor);
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {0, 4}, {4, 3}};
        System.out.println("Shortest path 0 -> 3: " + shortestPath(5, edges, 0, 3));
    }
}
