package unionFind;

import java.util.Arrays;

public class Fenfatangguo {
    public static void main(String[] args){
        int[] g = {1, 2};
        int[] s = {1, 2,3};
        int contentChildren = new Fenfatangguo().findContentChildren(g, s);
        System.out.println(contentChildren);
    }

    public int findContentChildren(int[] g,int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int candy = 0;
        while (child < g.length && candy < s.length) {
            if (g[child] <= s[candy]) {
                child++;
            }
            candy++;
        }
        return child;
    }
}
