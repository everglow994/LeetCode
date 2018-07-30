package Coding;

public class LongestPalindromeSubstring {
    public static String main(String s) {
        if(s.length() == 0 || s == null) {
            return "";
        }
        String result = "";
        int length = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                int len = j - i + 1;
                if(isPalindrome(s, i, j) && len > length) {
                    result = s.substring(i, j + 1);
                    length = len;
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    // dynamic programming
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0 || s == null) {
            return "";
        }

        String result = "";
        int maxLen = Integer.MIN_VALUE;

        boolean[][] dp = new boolean[len][len];


        for(int j = 0; j < len; j++) {
            for(int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 >= j || dp[i + 1][j - 1]);
                if(dp[i][j] && j - i + 1 > maxLen) {
                    result = s.substring(i, j + 1);
                    maxLen = j - i + 1;
                }
            }
        }

        return result;
    }


    // 2 pointers
    public String longestPalindromeIII(String s) {
        int len = s.length();
        if(len == 0 || s == null) {
            return "";
        }

        while(len > 0) {
            for(int i = 0; i + len - 1 < s.length(); i++) {
                int start = i;
                int end = i + len - 1;
                boolean valid = true;
                while(start < end) {
                    if(s.charAt(start) != s.charAt(end)) {
                        valid = false;
                        break;
                    }
                    start++;
                    end--;
                }
                if(valid) {
                    return s.substring(i, i + len);
                }
            }
            len--;
        }

        return "";
    }


}
