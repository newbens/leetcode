package SlidingWindow;

import java.util.Arrays;

public class 转置矩阵 {
    public static void main(String[] args){
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transpose = new 转置矩阵().transpose(a);
        System.out.println(Arrays.deepToString(transpose));
    }
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[m][n];
        int index = 0;
        for (int[] ma : matrix) {
            int col = 0;
            for (int i : ma) {
                res[col++][index] = i;
            }
            index++;

        }
        return res;
    }
}
