package TwoPointer;
import java.util.HashMap;

public class TwoSum {

    // 1. using hashmap
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int res = target - nums[i];
            if (map.containsKey(res)) {
                int j = map.get(res);
                return new int[]{j, i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException();
    }
}
