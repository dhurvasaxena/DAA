public class exponent1 {
    static float power(float a, int e){
        float pow=1;
        for (int i = 0; i < e; i++){
            pow = pow * a;
        }
        if (e<0){
            return 1/pow;
        }
        return pow;
    }
    public static void main(String[] args) {
        float a= 9.0f;
        int e= 3;
        float res= power(a,e);
        System.out.println(res);
    }
}

//Time Complexity : 0(e)

