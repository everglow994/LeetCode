package TwoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * just like two sum, but the sorted array has duplicate values, find all of them unique pairs that sum up to target value
 * [1, 1, 2, 3, 11, 11, 12, 12, 13, 13]
 */
public class TwoSumUniquePairs {
    public List<int[]> twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return null;
        List<int[]> ans = new ArrayList<>();
        int N = nums.length;
        int left = 0, right = N - 1;
        while(left < right) {
            int val = nums[left] + nums[right];
            if(val == target) {
                ans.add(new int[]{left, right});
                while(left < right && nums[left] == nums[left + 1]) left++;
                while(left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            } else if(val < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
