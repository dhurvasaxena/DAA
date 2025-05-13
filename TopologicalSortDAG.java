import java.util.*;
public class TopologicalSortDAG {
    static List<Integer> topologicalSort(int n, Map<Integer, List<Integer>> graph) {
        int[] inDegree = new int[n];
        for (int u : graph.keySet()) {
            for (int v : graph.get(u)) {
                inDegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        List<Integer> topOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topOrder.add(node);
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        if (topOrder.size() != n) return new ArrayList<>(); // Cycle detected or not a DAG
        return topOrder;
    }
    public static void main(String[] args) {
        int n = 6;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(5, Arrays.asList(2, 0));
        graph.put(4, Arrays.asList(0, 1));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(1));
        List<Integer> result = topologicalSort(n, graph);
        if (result.isEmpty()) {
            System.out.println("Cycle detected or not a DAG");
        } else {
            System.out.println(result);
        }
    }
}
