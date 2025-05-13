public class exponent2 {
    static float power(float a,int e){
        if (e==0){
            return 1;
        }
        if (e<0){
            return 1/power(a,e);
        }
        if (e%2==0){
            return power(a,e/2)*power(a,e/2);
        } else {
            return a*power(a,e/2)*power(a,e/2);
        }
    }

    public static void main(String[] args) {
        float a=4f;
        int e= 2;
        float res=power(a,e);
        System.out.println(res);
    }
}

//Time Complexity: O(log e)