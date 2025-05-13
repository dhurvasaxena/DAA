public class matrixMult {
    static int[][] multiply(int[][] arr, int[][] brr) {
        int n = arr.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += arr[i][k] * brr[k][j];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] arr = { {7, 8}, {2, 9} };
        int[][] brr = { {14, 5}, {5, 18} };
        int[][] res = multiply(arr, brr);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
