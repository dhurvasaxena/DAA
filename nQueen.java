import org.w3c.dom.ls.LSOutput;
import java.util.*;
class nQueen {
    static boolean isSafe(int k, int i, ArrayList<Integer> arr) {
        for (int j = 0; j < k; j++) {
            if (arr.get(j) == i || (Math.abs(arr.get(j) - i) == Math.abs(j - k))){
                return false; }
        } return true;
    }
    static int placeQueens(int k, int n, ArrayList<Integer> arr) {
        if (k == n) return 1;
        for (int i = 1; i <= n; i++) {
            if (isSafe(k, i, arr)) {
                arr.add(i);
                if (placeQueens(k + 1, n, arr) == 1)
                    return 1;
                arr.remove(arr.size() - 1);
            }
        } return 0;
    }
    static ArrayList<Integer> nQueen(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (placeQueens(0, n, arr) == 1)
            return arr;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        return res;
    }
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> ans = nQueen(n);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}