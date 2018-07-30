package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestNumber {

    // 打擂台做法，擂台是一个heap, 擂台只有k个站位
    // time complexity: O(Nlogk)    for every number, O(logK)
    // space complexity: O(K)

    public int KthLargestNumber(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) throw new IllegalArgumentException();
        Queue<Integer> heap = new PriorityQueue<>();   // create a min heap, max size is k
        for(int num: nums) {
            heap.offer(num);

            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();

    }



    // quick select 写法
    public int findK(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) throw new IllegalArgumentException();
        int index = quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
        return nums[index];
    }


    public int quickSelect(int[] nums, int low, int high, int k) {
        int i = low, j = high;
        int pivot = nums[high];
        while(i < j) {
            if(nums[i++] > pivot) {
                swap(nums, --i, --j);
            }
        }

        swap(nums, i, high);
        int m = i - low + 1;

        if(m == k) {
            return i;
        } else if(m > k) {
            return quickSelect(nums, low, i - 1, k);
        } else {
            return quickSelect(nums, i + 1, high, k - m);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
