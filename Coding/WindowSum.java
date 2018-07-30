package Coding;

import java.util.ArrayList;
import java.util.List;

public class WindowSum {

    public int[] winSum(int[] nums, int k) {
        // write your code here
        int len = nums.length;
        if(nums == null || len == 0 || k > len || k < 0)
            return new int[0];

        int[] ans = new int[len - k + 1];
        for(int i = 0; i < k; i++)
            ans[0] += nums[i];
        for(int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] - nums[i - 1] + nums[k + i - 1];
        }
        return ans;
    }


    // input 2
    public List<Integer> getSum(int[] nums, int k) {
        // write your code here
        int len = nums.length;
        if(nums == null || len == 0 || k > len || k < 0)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < k; i++)
            sum += nums[i];

        result.add(sum);
        for(int i = 1; i < len - k + 1; i++) {
            sum = sum - nums[i - 1] + nums[k + i - 1];
            result.add(sum);
        }
        return result;
    }

    // input 3
    public List<Integer> getSumII(List<Integer> A, int k) {
        ArrayList<Integer> result  = new ArrayList<>();
        if (A == null || A.size() == 0 || k <= 0) return result;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            count++;
            if (count >= k) {
                int sum = 0;
                for (int j = i; j >= i - k + 1; j--) {
                    sum += A.get(j);
                }
                result.add(sum);
            }
        }
        return result;
    }
}
