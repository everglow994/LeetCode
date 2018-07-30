package TwoPointer;

import java.util.Arrays;

/**
 * triangle count
 * sorted + 2 pointers
 * for each element, find two elements in precedent array elements that can make this triple form a triangle
 * let nums[i] = a,  other two edges b, c are precedent values, see that b < c < a
 * if c + b <= a left move to bigger, and  c - b must be smaller than a, so we ditch that condition
 * time: O(n^2) 2P + O(nlogn) sort
 * space: O(1)
 */
public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length <= 2) return 0;
        Arrays.sort(nums);
        int count = 0;
        int N = nums.length;
        for (int i = 2; i < N; i++) {
            int a = nums[i];
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > a) {
                    count += right - left;              // this line is ***
                    right--;                            // this line is ***
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}

