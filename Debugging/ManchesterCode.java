package Debugging;

public class ManchesterCode {

    public int[] manchester(int[] arr) {
        int[] output = new int[arr.length];
        if(arr == null || arr.length == 0 || arr.length == 1) {
            return output;
        }

        boolean result;
        for(int i = arr.length - 1; i > 0; i--) {
            result = (arr[i] == arr[i - 1]);
            output[i] = result ? 1 : 0;
        }

        return output;
    }


    // may need to consider when arr[0] = 0 and arr.length == 1
    public int[] manchesterD(int[] arr) {
        int[] output = new int[arr.length];
        if(arr == null || arr.length == 0 || arr.length == 1) {
            return output;
        }

        boolean result;
        for(int i = arr.length - 1; i > 0; i--) {
            result = (arr[i] != arr[i - 1]);   // this line
            output[i] = result ? 1 : 0;
        }

        return output;
    }
}
