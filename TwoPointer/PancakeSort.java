package TwoPointer;


/**
 *  Pancake Sort : using only flip actions on arrays to sort them
 *  example: [23, 10, 20, 11, 12, 6, 7]
 */
public class PancakeSort {
    public void pancakeSort(int[] nums) {
        int N = nums.length;
        if(nums == null || nums.length < 2) return;

        for(; N > 1; N--) {
            int index = findMax(nums, N - 1);
            if(index != N - 1) {
                flip(nums, index);
                flip(nums, N - 1);
            }
        }
    }


    public int findMax(int[] nums, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i <= end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public void flip(int[] nums, int end) {
        int start = 0;
        while(start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


