package TwoPointer;

import java.util.Arrays;

public class TwoSumLessEqual {
    public int twoSum(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        if(nums == null || nums.length < 2) return count;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            if(nums[left] + nums[right] <= target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
