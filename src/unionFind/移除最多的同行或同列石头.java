package unionFind;

import java.util.ArrayList;
import java.util.List;

public class 移除最多的同行或同列石头 {
    public static void main(String[] args){
        int[][] stones = {{0, 1}, {1, 2}, {1,3}, {3, 3}, {2, 3}, {0, 2}};
        System.out.println(new 移除最多的同行或同列石头().removeStones2(stones));
    }
    public int removeStones(int[][] stones) { //并查集解法
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                //如果两点中不管是横坐标还是纵坐标相同就可以合并为一个
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i,j);
                }
            }
        }
        return n - uf.getCount();
    }
    public int removeStones2(int[][] stones) {  //深度优先遍历解法
        int n = stones.length;
        List<List<Integer>> edge = new ArrayList<>();//存放可以行走的路径
        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                //说明相通
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    edge.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                //调用了几次这个函数就说明就几条相通的路，每一条路都只能留下来一个。
                num++;
                dfs(i,edge,visited);
            }
        }
        //最后返回总长度-有几条路。
        return n - num;
    }
    //深度优先遍历
    public void dfs(int x,List<List<Integer>> edge,boolean[] visited) {
        visited[x] =true;
        for (Integer i : edge.get(x)) {
            if (!visited[i]) {
                dfs(i,edge,visited);
            }
        }
    }
}
