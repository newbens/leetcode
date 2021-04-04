package unionFind;

public class 最小体力消耗路径 {
    int min = Integer.MAX_VALUE;
    int n;
    int m;
    public static void main(String[] args){
        int[][] h = {{10,8}, {10,8}, {1,2},{10,3},{1,3},{6,3},{5,2}};
        System.out.println(new 最小体力消耗路径().minimumEffortPath(h));
    }
    public int minimumEffortPath(int[][] heights) {
        boolean[][] history = new boolean[heights.length][heights[0].length];
        dfs(0,0,heights,heights[0][0],0,history);
        return min;
    }
    //这个方法会超时 ，使用下面二分法不会超市。
    public void dfs(int i,int j,int[][] h,int pre,int diff,boolean[][] history){
        if( i < 0 || i >= h.length || j <0 || j >= h[0].length || history[i][j])return;
        if (i == h.length - 1 && j == h[0].length - 1) {
            diff = Math.max(diff, Math.abs(h[i][j] - pre));
            min = Math.min(diff,min);
            return;
        }
        history[i][j] = true;
        dfs(i+1,j,h,h[i][j],Math.max(diff,Math.abs(h[i][j] - pre)),history);
        dfs(i-1,j,h,h[i][j],Math.max(diff,Math.abs(h[i][j] - pre)),history);
        dfs(i,j+1,h,h[i][j],Math.max(diff,Math.abs(h[i][j] - pre)),history);
        dfs(i,j-1,h,h[i][j],Math.max(diff,Math.abs(h[i][j] - pre)),history);
        history[i][j] = false;
    }
    //本方法采用二分法的思路，会解决超时问题。
    public int minimunEffortPath2(int[][] heights){
        n = heights.length;
        m = heights[0].length;
        int le = 0;
        int ri = 1000000;
        while (le < ri) {
            int mid = le + ri >>> 1;
            if (!dfs(0,0,mid,heights,new boolean[n][m])) {
                le = mid + 1;  //防止死循环
            }
            ri = mid;
        }
        return le;
    }

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //如果可以通过然会true说明当mid为这个值的时候 可以走到最后一个点，
    public boolean dfs(int i,int j,int max,int[][] h,boolean[][] visited) {
        if (i == n - 1 && j == m - 1) {
            return true;
        }
        //状态更新。
        visited[i][j] = true;
        for (int[] d : dir) {
            int newX = i + d[0];
            int newY = j + d[1];
            if (0 <= newX && newX < n && 0 <= newY && newY < m && !visited[newX][newY]) {
                if(Math.abs(h[newX][newY] - h[i][j]) > max) continue;
                if(dfs(newX,newY,max,h,visited)) return true;
            }
        }
        return false;
    }

}
