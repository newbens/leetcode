package unionFind;

import java.util.Arrays;

public class 打砖块 {
    public static void main(String[] args) {
        int[][] grid = {{1}, {1}, {1}, {1}, {1}};
        int[][] hits = {{3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}};
        int[] ints = new 打砖块().hitBricks(grid, hits);
        System.out.println(Arrays.toString(ints));
    }

    private int x;
    private int y;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        x = grid.length;
        y = grid[0].length;
        //1.全部击碎
        int[][] copy = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }
        //2.建图
        int size = x * y;
        MyUnionFind mu = new MyUnionFind(size + 1);
        //与屋顶合并
        for (int i = 0; i < y; i++) {
            if (copy[0][i] == 1) {
                mu.union(size, i);
            }
        }
        //与上左合并
        for (int i = 1; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (copy[i][j] == 1) {
                    if (copy[i - 1][j] == 1) {
                        mu.union(getIndex(i, j), getIndex(i - 1, j));
                    }
                    if (j > 0 && copy[i][j - 1] == 1) { //左边是
                        mu.union(getIndex(i, j), getIndex(i, j - 1));
                    }
                }
            }
        }
        //3.逆序 添加砖块
        int hLen = hits.length;
        int[] res = new int[hLen];
        for (int i = hLen - 1; i >= 0; i--) {
            int a = hits[i][0];
            int b = hits[i][1];
            if (grid[a][b] == 0) continue;
            int pre = mu.getSize(size);////获取合并之前的砖头数
            //补回砖块
            if (a == 0) mu.union(size, y);
            for (int[] d : dir) {
                int newX = a + d[0];
                int newY = b + d[1];
                if (check(newX, newY) && copy[newX][newY] == 1) {
                    mu.union(getIndex(a, b), getIndex(newX, newY));
                }
            }
            int cur = mu.getSize(size);
            res[i] = Math.max(0, cur - pre - 1);
            copy[a][b] = 1;
        }
        return res;

    }

    public boolean check(int x, int y) {  //判断是否出界
        return x >= 0 && x < this.x && y >= 0 && y < this.y;
    }

    public int getIndex(int a, int b) { //返回下标
        return a * y + b;
    }
}

class MyUnionFind extends UnionFind {

    public MyUnionFind(int n) {
        super(n);

    }

    public int getSize(int x) {
        return super.sz[find(x)];
    }
}