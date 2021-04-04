package unionFind;

public class 冗余连接 {
    int[] root;
    public int[] findRedundantConnection(int[][] edges) {
        root = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {  //初始化
            root[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {  //如果父节点相同说明是多余的连接
                return edge;
            }else union(edge[0],edge[1]);
        }
        return null;
    }
    public void union(int a,int b) {
            root[find(b)] = find(a);

    }
    public int find(int a) {  //找根节点
        if (root[a] != a) {
            root[a] = find(root[a]);
        }
        return root[a];
    }
}
