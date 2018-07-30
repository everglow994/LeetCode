package TwoPointer;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * example: Input: [2,0,2,1,1,0]   Output: [0,0,1,1,2,2]
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int i = 0, left = 0, right = nums.length - 1;

        // i <= right
        while(i <= right) {
            if(nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if(nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors_2pass(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            while(left < right && nums[left] < 1) left++;
            while(left < right && nums[right] >= 1) right--;
            if(left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if(nums[left] < 1) left++;
        right = nums.length - 1;
        while(left < right) {
            while(left < right && nums[left] <= 1) left++;
            while(left < right && nums[right] > 1) right--;
            if(left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}
