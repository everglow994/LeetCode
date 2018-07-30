package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, new ArrayList<>(), new HashSet<>(), result);
        return result;
    }


    private void helper(int[] nums,
                        List<Integer> sublist,
                        Set<Integer> set,
                        List<List<Integer>> result) {

        if(sublist.size() == nums.length) {
            result.add(new ArrayList<>(sublist));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                continue;
            }
            sublist.add(nums[i]);
            set.add(nums[i]);
            helper(nums, sublist, set, result);
            set.remove(nums[i]);
            sublist.remove(sublist.size() - 1);
        }
    }
}
