package DFS;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * well i know y'all thinking about two sum
 * but it;s different okay
 * example:
 * [2 3 6 7] target = 7
 * output:
 * [
 *  [7],
 *  [2, 2, 3]
 * ]
 */
public class CombinationSum {

    // 1. dfs recursion
    // O(2^N) time
    // O(N) space
    public List<List<Integer>> main(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }



    public void helper(int[] candidates,
                       int startIndex,
                       int remain,
                       List<Integer> combination,
                       List<List<Integer>> result) {

        // deep copy
        if(remain == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            if(remain < candidates[i]) {
                break;
            }

            if(i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            combination.add(candidates[i]);
            helper(candidates, i, remain - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
