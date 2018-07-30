package DP;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */

public class UglyNumberII {

    // 1. heap
    // thinking:
    // how to form the nth ugly number
    // an ugly number f = 2^x * 3^y * 5^z;
    // the next ugly number must be a former number times 2 or 3 or 5
    // so begin with 1(smallest ugly number), we times 2,3 and 5, get 3 new ugly number, put it in the min heap, find the smallest again and repeat this process

    // example : {1} in the min heap
    // 1  - 2, 3, 5 - {2, 3, 5}
    // 2  - 4, 6, 10 - {3, 5, 4, 6, 10}
    // 3  - 6, 9, 15 - {4, 5, 6, 9, 10, 15}
    // 4  - 8, 12, 20 - {5, 6, 8, 9, 10, 12, 15, 20}
    // 5 ...

    // be aware that 2 * 3 and 3 * 2 are the same number, so you need to find the unique one;

    // time complexity:  every poll execution of priority queue takes O(number of element in queue)

    //           analysis:  in the loop is O(log1) + O(log2) + .. + O(logN) = O(logN!) <= NO(logN)
    // space complexity: O(N)

    public int find(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet();
        queue.offer(new Long(1));
        Long ans = new Long(-1);
        Long[] bases = {2L, 3L, 5L};
        for(int i = 0; i < n; i++) {
            ans = queue.poll();
            for(Long base: bases) {
                if(!set.contains(base * ans)) {
                    queue.offer(base * ans);
                    set.add(base * ans);
                }
            }

        }
        return ans.intValue();
    }



    // 2. O(N) scan

    // 0 0 0 - 2 3 5 {2}
    // 1 0 0 - 4 3 5 {3}
    // 1 1 0 - 4 9 5 {4}

    // what is the explanation behind this algorithm??
    // intuition: every ugly number(i th) is multiply from a former ugly number (from 0 to i - 1) by 2, 3 or 5.
    // so an brute force way would be traverse from the 0 to i - 1 ugly number and multiply by 2, 3 and 5 to find the smallest one
    // here we use 3 value to record the latest smallest value that recently multiplied by 2, 3 and 5, we called them
    // n2, n3, n5

    // example:
    // the first ugly number is 1: we multiply it by 2, 3, 5, find smallest 2 , and record that we multiply 1 by 2 once
    // then the smallest number that we get by multiply 2 will be updated using 2(smallest now) * 2 = 4
    // so together with 4, 3, 5, we get smallest 3
    //
    public int scan(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if(dp[i] == n2) i2++; n2 = 2 * dp[i2];
            if(dp[i] == n3) i3++; n3 = 3 * dp[i3];
            if(dp[i] == n5) i5++; n5 = 5 * dp[i5];
        }
        return dp[n - 1];
    }
}

