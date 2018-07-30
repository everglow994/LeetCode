package TwoPointer;


/**
 * Partition an integers array into odd number first and even number second.
 * Example: Given [1, 2, 3, 4], return [1, 3, 2, 4]
 */
public class PartitionArrayByOddEven {
    public void partitionArray(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int N = nums.length;
        int left = 0, right = N - 1;
        while(left < right) {
            while(left < right && nums[left] % 2 == 1) left++;
            while(left < right && nums[right] % 2 == 0) right--;
            if(left < right) {
                int temp  = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}
