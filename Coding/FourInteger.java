package Coding;

import java.util.Arrays;

public class FourInteger {
    public int[] fourInteger(int A, int B, int C, int D) {
        int[] result = new int[4];
        result[0] = A;
        result[1] = B;
        result[2] = C;
        result[3] = D;
        Arrays.sort(result);
        swap(result, 0, 1);
        swap(result, 2, 3);
        swap(result, 0, 3);
        return result;
    }

    private void swap(int[] array, int i, int j) {
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }
}
