package unionFind;

public class 省份数量 {
    public static void main(String[] args){

    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {  //没访问过
                dfs(isConnected,visited,i);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] map,boolean[] visited,int s) {  //递归找出所有有关联的省份
        for (int i = 0; i < map.length; i++) {
            if (map[s][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(map,visited,i);
            }
        }
    }
}
