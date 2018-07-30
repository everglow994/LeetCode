package TwoPointer;

public class TwoSumSortedArray {

    //  if sorted array, using two sum
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return null;
        int N = nums.length;
        int start = 0, end = N - 1;
        while(start < end) {
            int val = nums[start] + nums[end];
            if(val == target) {
                return new int[]{start, end};
            } else if(val > target) {
                end--;
            } else {
                start++;
            }
        }
        throw new IllegalArgumentException();
    }
}
