package TwoPointer;


/**
 * partition an array
 * let all value < k to the left and value >= k to the right
 * return the first index of whose value is >= k
 * example [3 2 2 1]
 * method : two pointers
 *
 * [3 2 2 1]
 * [1 2 2 3]
 *
 */
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        int left = 0, right = N - 1;
        while(left < right) {
            while(left < right && nums[left] < k) left++;
            while(left < right && nums[right] >=k) right--;
            if(left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if(nums[left] < k) return left + 1;
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
