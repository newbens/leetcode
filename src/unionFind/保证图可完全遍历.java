package unionFind;

import java.util.Arrays;

public class 保证图可完全遍历 {
    int[][] all;//存放alice和bob的并查集 all[0]存放alice的 all[1]存放bob的
    public static void main(String[] args) {
        int[][] e = {{3,1,2}, {3,2,3}, {1,1,3}, {1,2,4}, {1,1,2},{2,3,4}};
        int n = 4;
        System.out.println(new 保证图可完全遍历().maxNumEdgesToRemove(n, e));
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int len = edges.length;
        all = new int[2][n];
        int res = 0;
        for (int i = 0; i < n; i++) { //初始化并查集
            all[0][i] = i;
            all[1][i] = i;
        }
        //排序让先合并双向路径
        Arrays.sort(edges,(a,b) ->Integer.compare(b[0],a[0]));
        for (int[] edge : edges) {
            if(edge[0] == 3){
                boolean unionA = union(0, edge[1] - 1, edge[2] - 1);
                boolean unionB = union(1, edge[1] - 1, edge[2] - 1);
                //如果有其中一个返回为false说明这条边已经合并过，结果加1.
                if(!(unionA && unionB)) res++;
            }else {
                //如果合并过返回false，结果加1.
                boolean union = union(edge[0]-1, edge[1] - 1, edge[2] - 1);
                if(!union) res++;
            }
        }
        return check(all[0]) && check(all[1]) ? res : -1;
    }
    //判断连通性。
    public boolean check(int[] p) {
        int count = 0;
        for (int i = 0; i < p.length; i++) {
            if(p[i] == i) count++;
        }
        return count == 1;
    }
    public boolean union(int index,int x,int y){
        int i = find(all[index], x);
        int j = find(all[index], y);
        if (i == j) {
            return false;
        }
        all[index][i] = j;
        return true;
    }
    public int find(int[] p,int x){
        if (p[x] != x) {
            p[x] = find(p,p[x]);
        }
        return p[x];
    }
}
