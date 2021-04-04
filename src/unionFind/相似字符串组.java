package unionFind;

public class 相似字符串组 {
    public static void main(String[] args){
        String[] strs = {"blw","bwl","wlb"};
        System.out.println(new 相似字符串组().numSimilarGroups(strs));
    }
    int[] par;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int iPar = find(i);
                int jPar = find(j);
                if(iPar == jPar)continue;
                if (check(strs[i], strs[j])) {
                    par[jPar] = iPar;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(par[i] == i) res++;
        }
        return res;
    }

    public int find(int x) {
        if (par[x] != x) {
            par[x] = find(par[x]);
        }
        return par[x];
    }

    public boolean check(String a,String b) {
        int n = a.length();
        int i = 0;
        int count = 0;
        while (i < n) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
