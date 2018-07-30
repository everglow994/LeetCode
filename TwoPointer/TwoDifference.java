package TwoPointer;
//import java.lang.*;

import java.util.HashMap;

/**
 * find a pair, whose difference is equal to target
 * return as [Index1, Index2] which index1 < index2, and both of them are not zero-based.
 *
 * Given nums = [2, 7, 15, 24], target = 5
 * return [1, 2] (7 - 2 = 5)
 */
public class TwoDifference {

    public int[] twoDifference(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];
        int N = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int res = nums[i] + Math.abs(target);
            int small = nums[i] -  Math.abs(target);
            if(map.containsKey(res)) {
                int index1 = i + 1;
                int index2 = map.get(res) + 1;
                if(index1 > index2) {
                    return new int[]{index2, index1};
                } else {
                    return new int[]{index1, index2};
                }
            }

            if(map.containsKey(small)) {
                int index1 = i + 1;
                int index2 = map.get(small) + 1;
                if(index1 > index2) {
                    return new int[]{index2, index1};
                } else {
                    return new int[]{index1, index2};
                }
            }

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
