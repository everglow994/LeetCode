package DFS;


import java.util.ArrayList;
import java.util.List;

/**
 * 所有的切割问题都是组合问题
 * 因为切割问题，是切割位置的组合问题
 * n个元素的切割问题，是n-1个切割位置的组合问题
 */

public class PalindromePartitioning {

    public List<List<String>> main(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }
        boolean[][] dp = isPalindrome(s);
        helper(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void helper(String s,
                       int index,
                       List<String> subset,
                       List<List<String>> result,
                        boolean[][] dp) {

        if(index == s.length()) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            if(!dp[index][i]) {
                continue;
            }
            subset.add(temp);
            helper(s, i + 1, subset, result, dp);
            subset.remove(subset.size() - 1);
        }
    }

    private boolean[][] isPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length(); j++) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        return dp;
    }
}
