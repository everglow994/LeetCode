package Coding;

public class ArithmeticSequence {
    public int as(int[] A) {
        if(A.length < 3 || A == null) {
            return 0;
        }
        int diff = 0;
        int count = 0;
        int start = 0;
        int result = 0;
        for(int i = 1; i < A.length; i++) {
            int curDiff = A[i] - A[i - 1];
            if(curDiff == diff) {
                count += i - start - 1;
            } else {
                diff = curDiff;
                start = i - 1;
                result += count;
                count = 0;
            }
        }
        result += count; // for a pure arithmetic sequence
        return result;
    }


    public int numberOfArithmeticSlices(int[] A) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            } else
                dp = 0;
        }
        return sum;
    }
}
