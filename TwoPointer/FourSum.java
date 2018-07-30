package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * find all unique quadruplets that sums up tp target
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 4) return ans;
        Arrays.sort(nums);
        int N = nums.length;

        for(int i = 0; i < N - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            threeSum(nums, i + 1, N - 1, target, nums[i], ans);
        }
        return ans;
    }

    public void threeSum(int[] nums, int left, int right, int target, int first, List<List<Integer>> ans) {
        for(int i = left; i <= right - 2; i++) {
            if(i > left && nums[i] == nums[i - 1]) continue;
            twoSum(nums, i + 1, nums.length - 1, target, first, nums[i], ans);
        }
    }

    public void twoSum(int[] nums, int left, int right, int target, int first, int second, List<List<Integer>> ans) {
        while(left < right) {
            if(nums[left] + nums[right] == target - first - second) {
                List<Integer> quadruplet = new ArrayList<>();
                quadruplet.add(first);
                quadruplet.add(second);
                quadruplet.add(nums[left]);
                quadruplet.add(nums[right]);
                ans.add(quadruplet);
                while(left < right && nums[left] == nums[left + 1]) left++;
                while(left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            } else if(nums[left] + nums[right] < target - first - second) {
                left++;
            } else {
                right--;
            }
        }
    }
}
