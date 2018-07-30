package Coding;

public class GCD {

    // find greatest common divisor
    public int solution(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }

        int gcd = array[0];
        for(int i = 1; i < array.length; i++) {
            gcd = gcdI(gcd, array[i]);
        }
        return gcd;
    }

    public static int gcdI(int a, int b) {
        int result = 1;
        for(int i = 1; i <= a; i++) {
            if(b % i == 0 && a % i == 0) {
                result = i;
            }
        }
        return result;
    }

    // 辗转相除法
    public static int gcdII(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcdII(b, a % b);
    }

    public static void main(String[] args) {
        System.out.print(gcdII(703, 407));
    }
}
