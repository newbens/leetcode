package unionFind;

import java.util.*;

public class 连接所有点的最小费用 {
    public static void main(String[] args){
        int[][] points = {{0,0}, {2,2}, {3,10}, {5,2}, {7,0}};
        int i = new 连接所有点的最小费用().minCostConnectPoints(points);
        System.out.println(i);

    }
    int[] parent;
    public int minCostConnectPoints(int[][] points) {
        List<Edge> list = new ArrayList<>();
        int n = points.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;//初始化
            for (int j = i+1; j < n; j++) {
                int len = getLen(points[i], points[j]);
                list.add(new Edge(i, j, len));
            }
        }
        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });
        int res = 0;
        for (Edge edge : list) {
            int x = edge.x;
            int y = edge.y;
            int len = edge.len;
            if(find(x) == find(y)) continue;
            union(x, y);
            res += len;
        }
        return res;
    }

    public int getLen(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    public int find(int x){
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x,int y) {
        int xParent = find(x);
        int yParent = find(y);
        if(xParent == yParent) return;
        parent[xParent] = yParent;
    }
}
class Edge{
    int x;
    int y;
    int len;

    public Edge(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }

}
