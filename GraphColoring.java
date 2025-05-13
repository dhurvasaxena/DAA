public class GraphColoring {
    final int V = 4;
    boolean isSafe(int v, int graph[][], int color[], int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && color[i] == c)
                return false;
        return true;
    }
    boolean graphColoringUtil(int graph[][], int m, int color[], int v) {
        if (v == V)
            return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1))
                    return true;
                color[v] = 0;
            }
        }
        return false;
    }
    boolean graphColoring(int graph[][], int m) {
        int[] color = new int[V];
        return graphColoringUtil(graph, m, color, 0);
    }
    int findMinColors(int graph[][]) {
        for (int m = 1; m <= V; m++) {
            if (graphColoring(graph, m)) {
                System.out.println("Minimum colors needed: " + m);
                return m;
            }
        }
        return V;
    }
    public static void main(String args[]) {
        GraphColoring g = new GraphColoring();
        int graph[][] = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };
        g.findMinColors(graph);
    }
}
