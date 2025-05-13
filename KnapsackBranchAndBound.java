import java.util.*;
class Item implements Comparable<Item> {
    int weight, profit;
    double ratio;
    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
    public int compareTo(Item other) {
        return Double.compare(other.ratio, this.ratio);
    }
}
class Node123 {
    int level, profit, weight;
    double bound;
    Node123(int level, int profit, int weight) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
    }
}
public class KnapsackBranchAndBound {
    static double bound(Node123 u, int n, int W, Item[] items) {
        if (u.weight >= W) return 0;
        double profitBound = u.profit;
        int j = u.level + 1;
        int totalWeight = u.weight;
        while (j < n && totalWeight + items[j].weight <= W) {
            totalWeight += items[j].weight;
            profitBound += items[j].profit;
            j++;
        }
        if (j < n) profitBound += (W - totalWeight) * items[j].ratio;
        return profitBound;
    }
    static int knapsack(int W, Item[] items, int n) {
        Arrays.sort(items);
        Queue<Node123> q = new LinkedList<>();
        Node123 u = new Node123(-1, 0, 0), v;
        u.bound = bound(u, n, W, items);
        q.offer(u);
        int maxProfit = 0;
        while (!q.isEmpty()) {
            u = q.poll();
            if (u.level == n - 1) continue;
            v = new Node123(u.level + 1, u.profit + items[u.level + 1].profit, u.weight + items[u.level
                    + 1].weight);
            if (v.weight <= W && v.profit > maxProfit) maxProfit = v.profit;
            v.bound = bound(v, n, W, items);
            if (v.bound > maxProfit) q.offer(v);
            v = new Node123(u.level + 1, u.profit, u.weight);
            v.bound = bound(v, n, W, items);
            if (v.bound > maxProfit) q.offer(v);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] profits = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        int n = profits.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) items[i] = new Item(weights[i], profits[i]);
        System.out.println("Max Profit:"+knapsack(W, items, n));
    }
}