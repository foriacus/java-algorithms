/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 1;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        
        for(int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        
        for(int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }

        for (int y = m - 2; y >= 0; y--) {
            for (int x = n - 2; x >= 0; x--) {
                dp[y][x] = Math.max(1, Math.min(dp[y+1][x], dp[y][x+1]) - dungeon[y][x]);
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

