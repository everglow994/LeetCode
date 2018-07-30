package TwoPointer;

import java.util.Arrays;

/**
 * find number of pairs that has sum greater than target
 */
public class TwoSumGreater {
    public int twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return 0;
        int count = 0;
        Arrays.sort(nums);

        int N = nums.length;
        int left = 0, right = N - 1;
        while(left < right) {
            if(nums[left] + nums[right] > target) {
                count += right - left;
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}
