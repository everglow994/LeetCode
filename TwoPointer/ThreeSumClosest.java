package TwoPointer;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSum(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;
        int ans = nums[0] + nums[1] + nums[2];
        int N = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < N - 2; ++i) {
            int left = i + 1, right = N - 1;
            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == target) return target;
                if(Math.abs(sum - target) < Math.abs(ans - target)) ans = sum;
                if(sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
