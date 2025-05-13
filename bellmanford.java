import java.util.*;
public class bellmanford {
    static class Edge {
        int source, dest, weight;
        Edge(int s, int d, int w) {
            source = s;
            dest = d;
            weight = w;
        }
    }
    public static void bellmanFord(int V, int E, List<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                if (dist[edge.source] != Integer.MAX_VALUE &&
                        dist[edge.source] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.source] + edge.weight;
                }
            }
        }
        for (Edge edge : edges) {
            if (dist[edge.source] != Integer.MAX_VALUE &&
                    dist[edge.source] + edge.weight < dist[edge.dest]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        System.out.println("Vertex distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }
    public static void main(String[] args) {
        int V = 5;
        int E = 8;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));
        bellmanFord(V, E, edges, 0);
    }
}