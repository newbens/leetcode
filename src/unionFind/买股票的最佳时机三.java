package unionFind;

import javax.jws.soap.SOAPMessageHandlers;
import java.util.Map;

public class 买股票的最佳时机三 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0]; //第一天就持有  还未交易一次
        dp[0][1][0] = 0;           //未持有股票 但交易了一次
        dp[0][1][1] = -prices[0];  //持有股票 且已经交易一次
        dp[0][2][0] = 0;           //未持有股票 但已经交易两次
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
        }
        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res = Math.max(dp[n - 1][i][j], res);
            }
        }
        return Math.max(res, dp[n - 1][2][0]);
    }
    public int maxProfit2(int[] prices) {   //对三维数组进行优化
        int n = prices.length;
        int[][] dp = new int[n][5];
        /**一共出现五种状态，可以用二维数组满足
         *   一： dp[n][0] 初始
         *   二： dp[n][1] 第一次买
         *   三： dp[n][2] 第一次卖
         *   四： dp[n][3] 第二次买
         *   五： dp[n][4] 第二次卖
         */
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;  //第一天买入又卖出 等于0；
        dp[0][3] = -prices[0];
        dp[0][4] = -0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);

        }
        return Math.max(Math.max( Math.max(dp[n-1][0],dp[n-1][1]),Math.max(dp[n-1][2],dp[n-1][3]) ),dp[n-1][4]);
    }
    public int maxProfit3(int[] prices) {   //对三维数组进行优化
        /**
         * 由第二解可以看出 每个状态只与之前的状态有关，所以可以简化为五个状态值，不需要数组浪费空间
         */
        int n = prices.length;

         int init = 0;
        int buy1 = -prices[0];
        int sell1 = 0;  //第一天买入又卖出 等于0；
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, init - prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell1 = Math.max(sell2, buy2 + prices[i]);
        }
        return Math.max(0,Math.max(Math.max(buy1,sell1),Math.max(buy2, sell2)));
    }
}
