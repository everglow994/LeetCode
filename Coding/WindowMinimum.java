package Coding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * add the minimum number within window size
 */
public class WindowMinimum {

    // time: O(KN)
    // Data Structure: Heap
    public int[] max(int[] nums, int k) {
        if(k > nums.length || nums.length == 0 || nums == null) {
            return new int[0];
        }

        Queue<Integer> queue = new PriorityQueue<>(k, (Integer a, Integer b) -> b - a);

        for(int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = queue.peek();

        for(int i = 1; i < result.length; i++) {
            queue.offer(nums[i + k - 1]);
            queue.remove(nums[i - 1]);   // this step is O(N)
            int max = queue.peek();
            result[i] = max;
        }



        return result;
    }


    // 实战里面return type是 ArrayList
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove larger numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] > nums[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = nums[q.peek()];
            }
        }
        return r;


    }
}
