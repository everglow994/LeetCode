package Debugging;

public class ReplaceValues {
    public static int[] replaceValues(int[] arr) {
        int i, j, len = arr.length;
        if(len % 2 == 0) {
            for(i = 0; i <= len; i++) {
                arr[i] = 0;
            }
        } else {
            for(j = 0; j <= len; j++) {
                arr[j] = 1;
            }
        }
        return arr;
    }

    public static int[] replaceValuesD(int[] arr) {
        int i, j, len = arr.length;
        if(len % 2 == 0) {
            for(i = 0; i < len; i++) {  // here
                arr[i] = 0;
            }
        } else {
            for(j = 0; j < len; j++) {  // here
                arr[j] = 1;
            }
        }
        return arr;
    }
}
