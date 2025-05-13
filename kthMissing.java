import java.util.*;

public class kthMissing {
    static int kthMissing(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        int res = arr.length + k;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > mid + k) {
                res = mid + k;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(kthMissing(arr, k));
    }
}
