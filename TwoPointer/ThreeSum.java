package TwoPointer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 * find unique triplets of index in the array which gives the sum of zero
 * method: for each elements in array, find the two sum of its negative value in the subsequent elements.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        int N = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < N - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(nums, i + 1, N - 1, -nums[i], ans);

        }
        return ans;
    }

    public void twoSum(int[] nums, int start, int end, int target, List<List<Integer>> ans) {

        while(start < end) {
            int val = nums[start] + nums[end];
            if(val == target) {
                List<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[start]);
                triple.add(nums[end]);
                ans.add(triple);
                while(start < end && nums[start] == nums[start + 1]) start++;
                while(start < end && nums[end] == nums[end - 1]) end--;
                start++;
                end--;
            } else if(val < target) {
                start++;
            } else {
                end--;
            }
        }
    }

}
