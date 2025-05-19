public class TSP {
    static int tsp(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        visited[0] = true; // Start at city 0 (arbitrary choice)
        return tspHelper(graph, visited, 0, 1, 0, Integer.MAX_VALUE);
    }

    static int tspHelper(int[][] graph, boolean[] visited, int currentPos, int count, int currentCost, int minCost) {
        // Base case: All cities visited. Return to start city.
        if (count == graph.length) {
            return currentCost + graph[currentPos][0];
        }

        // Try all unvisited cities
        for (int city = 0; city < graph.length; city++) {
            if (!visited[city] && graph[currentPos][city] != 0) {
                visited[city] = true;
                int newCost = currentCost + graph[currentPos][city];
                // Prune paths exceeding current minimum
                if (newCost < minCost) {
                    int result = tspHelper(graph, visited, city, count + 1, newCost, minCost);
                    minCost = Math.min(minCost, result);
                }
                visited[city] = false; // backtrack
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        // Example graph (4 cities)
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        System.out.println("Minimum TSP cost: " + tsp(graph)); // Output: 80
    }
}
