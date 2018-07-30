package Debugging;

public class InsertionSort {

    public void insertionSort(int[] arr) {
        // ascending
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                int temp = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] < temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }

    public void insertionSortD(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) { // this line
                int temp = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] < temp) { // this line
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }

}
