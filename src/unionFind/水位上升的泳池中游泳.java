package unionFind;

public class 水位上升的泳池中游泳 {
    int n;
    int m;
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
//        int[][] grid = {{0,1,2,3,4}, {24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int[][] grid = {{3,2}, {0,1}};
        System.out.println(new 水位上升的泳池中游泳().swimInWater(grid));
    }
    public int swimInWater(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int le = grid[0][0], ri = n * n - 1;
        while (le < ri) {
            int mid = le + ri >>> 1;
            if (!dfs(0, 0, mid, grid, new boolean[n][m])) {
                le = mid + 1;
            }else {
                ri = mid;
            }
        }
        return le;
    }

    public boolean dfs(int i, int j, int day, int[][] grid, boolean[][] visited) {
        if (i == n - 1 && j == m - 1) return true;
        visited[i][j] = true;
        for (int[] ints : dir) {
            int new_i = i + ints[0];
            int new_j = j + ints[1];
            if (0 <= new_i && new_i < n && 0 <= new_j && new_j < m && !visited[new_i][new_j]) {
                if(day < grid[new_i][new_j] ) continue;
                if(dfs(new_i,new_j,day,grid,visited)) return true;
            }
        }
        return false;
    }
}
