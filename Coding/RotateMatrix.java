package Coding;

/**
 * 把一个m*n的矩阵旋转90度，给一个flag规定是向左转还是向右转
 */
public class RotateMatrix {
    public static int[][] Solution(int[][] matrix, int flag) {
        int M = matrix.length;
        int N = matrix[0].length;
        if(matrix == null || M == 0)
            return matrix;

        // 按行翻转 或者 按列翻转
        if(flag == 1) {
            int start = 0, end = M - 1;
            while (start < end) {
                int[] temp = matrix[start];
                matrix[start] = matrix[end];
                matrix[end] = temp;
                start++;
                end--;
            }
        } else {
            int start = 0, end = N - 1;
            while (start < end) {
                for(int i = 0; i < M; i++) {
                    int temp = matrix[i][start];
                    matrix[i][start] = matrix[i][end];
                    matrix[i][end] = temp;
                }
                start++;
                end--;
            }
        }

        // 沿对角线翻转， 求transpose

        for(int i = 0; i < M; i++) {
            for(int j = i + 1; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        arr = Solution(arr, 0);
        for(int[] ar: arr) {
            for(int num: ar) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }

}
