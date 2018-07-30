package Debugging;

public class RemoveElement {
    public static int[] removeElement(int[] arr, int index){
        int i, j, len = arr.length;
        if(index < len) {
            for(i = index; i < len - 1; i++) {
                arr[i] = arr[i++];
            }
            int[] rarr = new int[len - 1];
            for(i = 0; i < len - 1; i++) {
                rarr[i] = arr[i];
            }
            return rarr;
        } else {
            return arr;
        }
    }

    public static int[] removeElementD(int[] arr, int index){
        int i, j, len = arr.length;
        if(index < len) {
            for(i = index; i < len - 1; i++) {
                arr[i] = arr[i + 1]; // this line
            }
            int[] rarr = new int[len - 1];
            for(i = 0; i < len - 1; i++) {
                rarr[i] = arr[i];
            }
            return rarr;
        } else {
            return arr;
        }
    }
}
