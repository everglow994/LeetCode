package TwoPointer;


/** Leetcode 31
 * Next Permutation
*/
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int N = nums.length;
        int small = -1;
        for(int i = N - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                small = i;
                break;
            }
        }
        if(small == -1) {
            reverse(nums, 0, N - 1);
            return;
        }

        int large = -1;
        for(int i = N - 1; i >= 0; i--) {
            if(nums[i] > nums[small]) {
                large = i;
                break;
            }
        }

        swap(nums, small, large);
        reverse(nums, small + 1, N - 1);
    }


    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i++, j--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
