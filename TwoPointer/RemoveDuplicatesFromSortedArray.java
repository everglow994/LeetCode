package TwoPointer;


/**
 * note that the array is already sorted
 * return the index of the last unique value in the array
 * algorithm: two pointer
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicateFromSortedArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        int cur = 0;
        for(int i = 0; i < N; i++) {
            if(nums[cur] != nums[i]) {
                cur++;
                nums[cur] = nums[i];
            }
        }
        return cur;
    }
}
