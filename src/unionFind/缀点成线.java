package unionFind;

public class 缀点成线 {
    public static void main(String[] args){
        int[][] a = {{1, -8}, {2, -3}, {1, 2}};
        System.out.println(new 缀点成线().checkStraightLine(a));
    }
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        int x = coordinates[n - 1][0] - coordinates[0][0];
        int y = coordinates[n - 1][1] - coordinates[0][1];
        for(int i = n-2; i > 0;i--){
            int a = coordinates[i][0] - coordinates[0][0];
            int b = coordinates[i][1] - coordinates[0][1];
            if(x == 0 && a != 0)return false;
            if(y == 0 && b != 0)return false;
            if(a == 0 && x != 0) return false;
            if(b == 0 && y != 0) return false;
            return a * y == b * x;
        }
        return true;
    }
}
