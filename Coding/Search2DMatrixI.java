package Coding;

public class Search2DMatrixI {

    // 通用的 O(M + N) 的做法， 不用二分， 扫描搜索（模拟）
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int M = matrix.length, N = matrix[0].length;
        int m = 0, n = N - 1;
        while(m < M && n >= 0) {
            if(matrix[m][n] == target) {
                return true;
            }
            if(matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
