package TwoPointer;


/**
 * Given an array with positive and negative integers.
 * Re-range it to interleaving with positive and negative integers.
 *
 * Given [-1, -2, -3, 4, 5, 6], after re-range,
 * it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.
 */

public class InterleavingPositiveNegative {
    public void partitionArray(int[] nums) {
        if(nums == null || nums.length == 0) return;

        // step 1.
        // partition so that negative and positive are separate
        // always partition as negative numbers first then positive numbers
        int left = 0, right = nums.length - 1;
        while(left < right) {
            while(left < right && nums[left] < 0) left++;
            while(left < right && nums[right] >0) right--;
            if(left < right) {
                swap(nums, left, right);
                left++; right--;
            }
        }

        // step 2.
        // find the first positive index
        if(nums[left] < 0) left = left + 1;

        // step 3.
        // check whether array has more positive or negative numbers
        // change left and right pointers accordingly;

        if(nums.length % 2 == 0) {
            left = 0; right = nums.length - 1;
        } else if(left <= nums.length / 2) {
            left = 0; right = nums.length - 2;
        } else {
            left = 1; right = nums.length - 1;
        }

        // step 2. interleaving pos and neg value;
        while(left < right) {
            swap(nums, left, right);
            left += 2;
            right -= 2;
        }

    }

    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }
}
