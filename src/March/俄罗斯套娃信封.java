package March;

import java.util.Arrays;

public class 俄罗斯套娃信封 {
    public static void main(String[] args) {
        int[][] es = {{1,1}, {1,1}, {1,1}};
        System.out.println(new 俄罗斯套娃信封().maxEnvelopes(es));
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return n;
        int res = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i-1; j >=0 ; j--) {
                if (check(envelopes[j],envelopes[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    boolean check(int[] a,int[] b) {
        return a[0] < b[0] && a[1] < b[1];
    }
}
