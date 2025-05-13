public class minmaxarr1 {
    static class Pair {
        int max;
        int min;
    }
    static Pair maxMinNaive(int[] arr) {
        Pair result = new Pair();
        result.max = arr[0];
        result.min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > result.max) {
                result.max = arr[i];
            }
            if (arr[i] < result.min) {
                result.min = arr[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, 4, 26, 14, 33, 64, 46};
        Pair result = maxMinNaive(arr);
        System.out.println("Maximum element is: " + result.max);
        System.out.println("Minimum element is: " + result.min);
    }
}