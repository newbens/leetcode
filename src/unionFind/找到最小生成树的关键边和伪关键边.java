package unionFind;

import java.util.*;

public class 找到最小生成树的关键边和伪关键边 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}};
        List<List<Integer>> res = new 找到最小生成树的关键边和伪关键边().findCriticalAndPseudoCriticalEdges(n, edges);
        System.out.println(res);
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Ed> list = new ArrayList<>();
        int len = edges.length;
        UnionFind u = new UnionFind(n); //边的并查集
        for (int i = 0; i < len; i++) {
            list.add(new Ed(i, edges[i][0], edges[i][1], edges[i][2]));
        }
        int minWeight = getMinTreeWeight(list,u,0);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());//存放关键边
        res.add(new ArrayList<>());//存放非关键边
        //判断是否是关键边
        List<Ed> tempEdge = new ArrayList<>(list);
        for (Ed edge : list) {
            tempEdge.remove(edge);
            if (minWeight != getMinTreeWeight(tempEdge,new UnionFind(n),0)) {
                res.get(0).add(edge.index);
            }
            tempEdge.add(edge);
        }
        //判断是否为非关键边
        for (Ed e : list) {
            if(res.get(0).contains(e.index)) continue;
            //先连接这个边权重没变就是伪关键边
            UnionFind newU = new UnionFind(n);
            newU.union(e.x, e.y);
            if (minWeight == getMinTreeWeight(tempEdge,newU,e.w)) {
                res.get(1).add(e.index);
            }
        }
        return res;
    }

    public int getMinTreeWeight(List<Ed> list,UnionFind u,int weight) {//找到最小生成数的权值
        Collections.sort(list, (a, b) -> a.w - b.w);
        for (Ed edge : list) {
            int root1 = u.find(edge.x);
            int root2 = u.find(edge.y);
            if (root1 != root2) {
                weight += edge.w;
                u.union(root1,root2);
            }
        }
        return weight;
    }

}

class Ed {
    int index;
    int x;
    int y;
    int w;

    public Ed(int index, int x, int y, int w) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.w = w;
    }
}
