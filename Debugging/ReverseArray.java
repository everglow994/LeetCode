package Debugging;

public class ReverseArray {
    public static int[] reverseArray(int[] arr) {
        int i, temp, originalLen = arr.length;
        int len = originalLen;
        for(i = 0; i < originalLen / 2; i++) {
            temp = arr[len - 1];
            arr[len - 1] = arr[i];
            arr[i] = temp;
            len += 1;
        }
        return arr;
    }

    public static int[] reverseArrayD(int[] arr) {
        int i, temp, originalLen = arr.length;
        int len = originalLen;
        for(i = 0; i < originalLen / 2; i++) {
            temp = arr[len - 1 - i];
            arr[len - 1 - i] = arr[i];
            arr[i] = temp;
//            len += 1;
        }
        return arr;
    }
}
