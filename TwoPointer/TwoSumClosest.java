package TwoPointer;

import java.util.Arrays;

public class TwoSumClosest {
    public int twoSum(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        if(nums == null || nums.length < 2) return -1;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while(left < right) {
            diff = Math.abs(nums[left] + nums[right] - target) < diff ? Math.abs(nums[left] + nums[right] - target) : diff;
            if(nums[left] + nums[right] == target) {
                return 0;
            } else if(nums[left] + nums[right] > target){
                right--;
            } else {
                left++;
            }
        }
        return diff;
    }
}
