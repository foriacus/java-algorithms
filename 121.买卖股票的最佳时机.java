/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // L[i] 记录 最小值
        // P[i] = max{P[i-1], price[i] - L[i]}
        // return P[n-1]
        int n = prices.length;
        if (n < 1) return 0;
        int[] lowest = new int[n];
        int[] maxProfit = new int[n];
        lowest[0] = prices[0];
        maxProfit[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            lowest[i] = Math.min(lowest[i - 1], prices[i]);
            maxProfit[i] = Math.max(maxProfit[i-1], prices[i] - lowest[i]);
        }
        return maxProfit[n-1];
    }

    // 方法二：
    // 记录gains[i] = price[i] - price[i-1]
    // P[i] = max{gains[i], P[i-1]+gains[i]}
    // return max{ ...P[i] }
}
// @lc code=end

