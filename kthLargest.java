import java.util.PriorityQueue;
public class kthLargest {
    public static int kthLargest(int[] arr, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) {
            pq.add(val);
            if (pq.size() > K)
                pq.poll();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int K = 2;
        System.out.println(kthLargest(arr, K));
    }
}

