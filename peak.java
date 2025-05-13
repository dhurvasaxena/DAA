
class peak {
    static int peakElement(int[] arr) {
        int n = arr.length;
        if (n == 1){
            return 0; }
        if (arr[0] > arr[1]){
            return 0;}
        if (arr[n - 1] > arr[n - 2]){
            return n - 1;}
        int lo = 1, hi = n - 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;}
            if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            }else{
                hi = mid - 1;}
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 8, 3};
        System.out.println("Peak element:"+peakElement(arr));
    }
}
