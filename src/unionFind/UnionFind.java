package unionFind;

public class UnionFind {  //并查集
    private int[] id; //用来存放每个index的上级
    public int[] sz;//存放每个index有多少个下级个数
    private int count;

    public UnionFind(int n) { //初始化
        count = n;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;//初始化结束，每个下标的上级都是自己
            sz[i] = 1;//每个下标的下级只有自己一个
        }
    }

    public UnionFind() {
    }

    public int getCount() {
        return count;
    }

    public int find(int p) {//寻找老大
        if (p != id[p]) {//如果自己不是自己的老大
            id[p] = find(id[p]); //递归寻找自己的老大，并且更新状态
        }
        return id[p];
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p,int q) {
        int pRoot = find(p); //找到p的老大
        int qRoot = find(q);//找到q的老大
        if(pRoot == qRoot) return;//如果相同说明是同一个组的人，直接返回
        if(sz[pRoot] < sz[qRoot]){//如果p组的小弟多于q组，吞并q组，并且q组成为p组小弟。
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }
}
