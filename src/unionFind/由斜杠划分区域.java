package unionFind;

public class 由斜杠划分区域 {
    public static void main(String[] args) {
        String[] grid = {" /",
                "  "};
        System.out.println(new 由斜杠划分区域().regionsBySlashes(grid));
    }

    /**
     * @param grid
     * @return
     * 把‘/’转化为 001
     *           010
     *           100
     * 把‘\’转化为 100
     *           010
     *           001
     * 把‘’转化为  000
     *           000
     *           000
     * 这个题就成了岛屿问题
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] map = new boolean[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    map[i * 3][j * 3 + 2] = true;
                    map[i * 3 + 1][j * 3 + 1] = true;
                    map[i * 3 + 2][j * 3] = true;
                } else if (grid[i].charAt(j) == '\\') {
                    map[i * 3][j * 3] = true;
                    map[i * 3 + 1][j * 3 + 1] = true;
                    map[i * 3 + 2][j * 3 + 2] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n*3; i++) {
            for (int j = 0; j < n*3; j++) {
                if (map[i][j] == false) {
                    dfs(map,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] map,int i,int j) {
        int n = map.length;
        if (i >= 0 && i < n && j >= 0 && j < n && map[i][j] == false) {
            map[i][j] = true;
            dfs(map,i+1,j);
            dfs(map,i-1,j);
            dfs(map,i,j+1);
            dfs(map,i,j-1);
        }
    }
}
