package unionFind;

import java.util.Arrays;

public class 等价多米诺数量 {
    public static void main(String[] args) {
        int[][] d = {{1,2}, {1,2}, {1,1}, {1,2},{2,2}};
        System.out.println(new 等价多米诺数量().numEquivDominoPairs(d));
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;
    }
}
