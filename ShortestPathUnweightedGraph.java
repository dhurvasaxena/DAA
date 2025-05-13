import java.util.*;
public class ShortestPathUnweightedGraph {
    static void bfsShortestPath(Map<Integer, List<Integer>> graph, int source, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        dist[source] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.getOrDefault(u, new ArrayList<>())) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + (dist[i] == -1 ? "Unreachable" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int n = 6;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, Arrays.asList(1, 2, 5));
        graph.put(5, Arrays.asList(3, 4));
        int source = 0;
        bfsShortestPath(graph, source, n);
    }
}