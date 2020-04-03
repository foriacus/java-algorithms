/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 第 i 天 j 次交易
        // global[i][j] 当前到达第i天可以最多进行j次交易，最好的利润是多少
        // local[i][j] 当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少
        // global[i][j] = max(local[i][j], global[i-1][j])
        // local[i][j] = max(global[i-1][j-1] + max(diff, 0), local[i-1][j] + diff)
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] global = new int[n][3];
        int[][] local = new int[n][3];

        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= 2; j++) {
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        return global[n-1][2];
    }
}
// @lc code=end

