package TwoPointer;


/**
 * alias: rainbow sort
 * sort k colors numbers are ranging from 1 to k.
 * methods:
 * examples:
 */
public class SortColorsII {

//    public void countingSort(int[] nums, int k) {
//        int[] count = new int[k];
//        for (int i = 0; i < nums.length; i++) {
//            count[nums[i] - 1] += 1;
//        }
//        int cur = 0;
//        for (int i = 0; i < k; i++) {
//            while (count[i] > 0) {
//                nums[cur] = i + 1;
//                cur++;
//                count[i]--;
//            }
//        }
//    }


    public void rainbowSort(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        partitionArray(nums, 0, nums.length - 1, 1, k);
    }

    public void partitionArray(int[] nums,
                               int left,
                               int right,
                               int min,
                               int max) {

        if (left >= right || min == max) return;
        int mid = (min + max) / 2;
        int l = left, r = right;

        while (l < r) {
            while (l < r && nums[l] <= mid) l++;
            while (l < r && nums[r] > mid) r--;
            if (l < r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        if(nums[l] <= mid) l++;

        partitionArray(nums, left, l - 1, min, mid);
        partitionArray(nums, l, right, mid + 1, max);

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}

