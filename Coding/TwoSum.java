package Coding;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // return index (1-based)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if(map.containsKey(res)) {
                return new int[]{map.get(res), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException();
    }
}
