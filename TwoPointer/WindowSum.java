package TwoPointer;

public class WindowSum {

    public int[] windowSum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return null;
        int N = nums.length;
        if(k > N) k = N;
        int[] ans = new int[N - k + 1];
        int sum = 0;
        for(int i = 0; i < k; i++) sum += nums[i];
        int start = 0, end = k - 1;
        for(int i = 0; i < N - k + 1; i++) {
            ans[i] = sum;
            sum -= nums[start++];
            if(end + 1 < N) sum += nums[++end];
        }
        return ans;
    }
}
