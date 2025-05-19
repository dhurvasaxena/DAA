import java.util.*;

public class TopologicalSort {
    private int vertices;  // Number of vertices
    private List<List<Integer>> adj;  // Adjacency list

    public TopologicalSort(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add a directed edge from u to v
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    // Recursive DFS function
    private void dfs(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(node);  // Push after visiting neighbors
    }

    // Function to perform topological sort
    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        // Print topological order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Main function to test
    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        
        System.out.println("Topological Sort:");
        graph.topologicalSort();
    }
}
