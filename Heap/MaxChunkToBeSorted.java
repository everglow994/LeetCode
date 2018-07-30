package Heap;

import java.util.Stack;


/** Leetcode 768
 * Max Chunks To Make Sorted
 *
 * example to be considered:
 *  2 1 3 4 4 -> 4
 *  1 1 0 0 1 -> 2
 */
public class MaxChunkToBeSorted {

//    public int maxChunkToBeSorted(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        int N = nums.length;
//        int count = 0;
//
//        int[] leftMax = new int[N], rightMin = new int[N];
//        leftMax[0] = nums[0];
//        rightMin[N - 1] = nums[N - 1];
//
//        for(int i = 1; i < N; i++) {
//            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
//        }
//
//        for(int i = N - 2; i >= 0; i--) {
//            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
//        }
//
//        for(int i = 0; i < N; i++) {
//            if(leftMax[i] <= rightMin[i + 1]) count++;
//        }
//        return count + 1;
//    }

    // stack solution
    public int maxChunkToBeSorted(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            if(stack.isEmpty() || nums[i] >= stack.peek()) {
                stack.push(nums[i]);
                continue;
            }
            int temp = stack.peek();
            // nums[i] < stack.peek(), to find out which chunk this val belongs
            while(!stack.isEmpty() && nums[i] < stack.peek()) {
                stack.pop();
            }
            stack.push(temp);
        }
        return stack.size();
    }
}
