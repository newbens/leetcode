package unionFind;

public class 连接网络的操作次数 {
    public static void main(String[] args) {
        int[][] c = {{0, 1}, {0,2},{2,3},  {3,4},};
        int n = 5;
        System.out.println(new 连接网络的操作次数().makeConnected(n, c));
    }
    int[] parents;
    public int makeConnected(int n, int[][] connections) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int x = 0, y = -1;
        for (int[] connection : connections) {
            int a = find(connection[0]);
            int b = find(connection[1]);
            if(a == b)x++;  //多余的线
            else {
                parents[b] = a;
            }
        }
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                y++;
            }
        }
        return x < y  ? -1 : y;
    }

    public int find(int a) {
        if (parents[a] != a) {
            parents[a] = find(parents[a]);
        }
        return parents[a];
    }
}
