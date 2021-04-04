package SlidingWindow;

public class 托普利茨矩阵 {
    public static void main(String[] args){
        int[][] m = {{53, 64, 90, 98, 34}, {91, 53, 64, 90, 98}, {17, 91, 53, 64, 0}};
        System.out.println(new 托普利茨矩阵().isToeplitzMatrix(m));
    }
    int m,n;
    public boolean isToeplitzMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if(!check(matrix,i,0)) return false;
        }
        for (int i = 0; i < n; i++) {
            if(!check(matrix,0,i)) return false;
        }
        return true;
    }

    public boolean check(int[][] matrix, int x, int y) {
        int nextX = x+1;
        int nextY = y+1;
        if(nextX >= m || nextY >=n) return true;
        else {
            if (matrix[nextX][nextY] == matrix[x][y]) {
                return check(matrix, nextX, nextY);
            } else return false;
        }
    }
}
