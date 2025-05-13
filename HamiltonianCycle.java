public class HamiltonianCycle {
    final int V = 5;
    int path[];
    boolean isSafe(int v, int graph[][], int path[], int pos) {
        if (graph[path[pos - 1]][v] == 0) return false;
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) return false;
        }return true;
    }
    boolean hamCycleUtil(int graph[][], int path[], int pos) {
        if (pos == V) {
            return graph[path[pos - 1]][path[0]] == 1;
        }
        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                if (hamCycleUtil(graph, path, pos + 1)) return true;
                path[pos] = -1;
            }
        }return false;
    }
    void hamCycle(int graph[][]) {
        path = new int[V];
        for (int i = 0; i < V; i++) path[i] = -1;
        path[0] = 0;
        if (!hamCycleUtil(graph, path, 1)) {
            System.out.println("No Hamiltonian Cycle found");
            return;
        }
        printSolution(path);
    }
    void printSolution(int path[]) {
        System.out.print("Hamiltonian Cycle: ");
        for (int i = 0; i < V; i++) System.out.print(path[i] + " ");
        System.out.println(path[0]);
    }
    public static void main(String args[]) {
        HamiltonianCycle h = new HamiltonianCycle();
        int graph1[][] = {{0, 1, 0, 1, 0},{1, 0, 1, 1, 1},{0, 1, 0, 0, 1},{1, 1, 0, 0, 1},{0, 1, 1, 1, 0}};
        h.hamCycle(graph1);
    }
}

