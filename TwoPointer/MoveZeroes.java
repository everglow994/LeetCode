package TwoPointer;

/**
 * exampple:
 * I : 0 1 0 3 12
 * o : 1 3 12 0 0
 * Algorithms: two pointers
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int ansPos = 0;
        int N = nums.length;
        for(int i = 0; i < N; i++) {
            if(nums[i] != 0) {
                nums[ansPos] = nums[i];
                ansPos++;
            }
        }
        for(int i = ansPos; i < N; i++) nums[i] = 0;
    }
}
