package unionFind;

public class 买卖股票的最佳时机 {
    public static void main(String[] args){
        int[] p = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(new 买卖股票的最佳时机().maxProfit(k, p));

    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0)return 0;
        if (k >= n / 2) {
            return help(prices);
        }
        int[][] dp = new int[k+1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][1] =-prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if(j < k){
                    /**今天不持有股票无非就两种情况：
                     * 1.昨天也未持有
                     * 2.今天卖出
                     */
                    dp[j][0] =Math.max(dp[j][0],dp[j+1][1] + prices[i]);
                }else {
                    dp[j][0] = dp[j][0];
                }
                /**
                 * 今天持有股票的情况也分为两种：
                 * 1.昨天就持有
                 * 2.今天刚买入
                 */
                dp[j][1] = Math.max(dp[j][1],dp[j][0] - prices[i]);
            }
        }
        return dp[0][0];

    }

    public int help(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += (prices[i] - prices[i - 1]);
            }
        }
        return res;
    }
}
