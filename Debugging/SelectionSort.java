package Debugging;

public class SelectionSort {


    public void selectionSort(int[] arr) {
        int x, y;
        int n = arr.length;
        for (x = 0; x < n; x++) {
            int index_of_min = x;
            for (y = x; y < n; y++) {
                if (arr[index_of_min] > arr[x]) {
                    y = index_of_min;
                }
                int temp = arr[x];
                arr[x] = arr[index_of_min];
                arr[index_of_min] = temp; }
        }
    }

    // ascending order
    public void selectionSortD(int[] arr) {
        int x, y;
        int n = arr.length;
        for (x = 0; x < n; x++) {
            int index_of_min = x;
            for (y = x; y < n; y++) {
                if (arr[index_of_min] > arr[y]) {   // this line
                    y = index_of_min;
                }
                int temp = arr[x];
                arr[x] = arr[index_of_min];
                arr[index_of_min] = temp; }
        }
    }
}
