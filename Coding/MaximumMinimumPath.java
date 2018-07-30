package Coding;

import java.util.ArrayList;
import java.util.List;

public class MaximumMinimumPath {

    // good dp
    public static int maximumMinimumPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];                                // dp[i,j]路径中最小值 (不过下边有所不同)
        dp[0][0] = matrix[0][0];// [0,0] 肯定在考虑点中
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(Math.max(dp[i - 1][j], dp[i][j - 1]),// 每次选点的时候,因为路径只可能是从上或者从左, 所以选其中较大的, 再去合当前值比较.即可
                        matrix[i][j]);
            }
        }
        return dp[n - 1][m - 1];
    }

    // dfs
    public static int dfs(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        List<Integer> min = new ArrayList<>();
        helper(matrix, 0, 0, matrix[0][0], min);
        int max = Integer.MIN_VALUE;
        for(int num: min) {
            max = num > max ? num : max;
        }
        return max;
    }

    private static void helper(int[][] matrix,
                          int i,
                          int j,
                          int localMin,
                          List<Integer> min) {
        if(i >= matrix.length || j >= matrix[0].length) {
            return;
        }
        if(i == matrix.length - 1 && j == matrix[0].length - 1) {
            min.add(localMin);
        }
        localMin = matrix[i][j] < localMin ? matrix[i][j] : localMin;
        int[] dirX = {0, 1};
        int[] dirY = {1, 0};
        for(int l = 0; l < 2; l++) {
            helper(matrix, i + dirX[l], j + dirY[l], localMin, min);
        }
    }

    // my complex solution TAT
    public static int helper(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        List[][] dp = new ArrayList[M][N];
        dp[0][0] = new ArrayList<>();
        dp[0][0].add(matrix[0][0]);

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(i == 0 && j == 0) {
                    continue;
                } else if(i == 0) {
                    if (matrix[0][j] < matrix[0][j - 1]) {
                        dp[0][j] = new ArrayList<>();
                        dp[0][j].add(matrix[0][j]);
                    } else {
                        dp[0][j] = new ArrayList(dp[0][j - 1]);
                    }
                } else if(j == 0) {
                    if(matrix[i][0] < matrix[i - 1][0]) {
                        dp[i][0] = new ArrayList<>();
                        dp[i][0].add(matrix[i][0]);
                    } else {
                        dp[i][0] = new ArrayList(dp[i - 1][0]);
                    }
                } else {
                    dp[i][j] = new ArrayList<>();
                    List<Integer> left = dp[i][j - 1];
                    List<Integer> up = dp[i - 1][j];
                    for(int x = 0; x < left.size(); x++) {
                        if(matrix[i][j] < left.get(x)) {
                            left.set(x, matrix[i][j]);
                        }
                        dp[i][j].add(left.get(x));
                    }

                    for(int x = 0; x < up.size(); x++) {
                        if(matrix[i][j] < up.get(x)) {
                            up.set(x, matrix[i][j]);
                        }
                        dp[i][j].add(up.get(x));
                    }
                }
            }
        }

        List<Integer> result = dp[M - 1][N - 1];
        int max = Integer.MIN_VALUE;
        for(int num: result) {
            max = num > max ? num : max;
        }
        return max;
    }



    // xiaotudao dfs
    private static int min, max, row, col;
    public static int maxMinPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfsHelper(matrix, min, 0, 0);
        return max;
    }

    public static void dfsHelper(int[][] matrix, int min, int i, int j ){
        if (i >= row || j >= col) return;
        if (i == row - 1 && j == col - 1) {
            min = Math.min(min, matrix[i][j]);
            max = Math.max(max, min);
            return;
        }
        min = Math.min(min, matrix[i][j]);
        dfsHelper(matrix, min, i, j + 1);
        dfsHelper(matrix, min, i + 1, j);
    }

    public static void main(String[] args) {
        int[][] array = {
                {8,4,3,5},
                {6,5,9,8},
                {7,2,3,6}
        };
        System.out.print(maxMinPath(array));
    }
}
