package Debugging;

public class SortArray {

    // bug version
    public static int[] sortArray(int arr[]) {
        int len = arr.length;
        int temp;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                temp = 0;
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    // debug version
    public static int[] sortArrayD(int[] arr) {
        int len = arr.length;
        int temp;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                temp = 0;
                if(arr[i] < arr[j]) { // here
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}


