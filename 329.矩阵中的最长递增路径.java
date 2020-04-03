/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 */

// @lc code=start
class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 1;
        int[][] dp =  new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, dp, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int[][] dp, int i , int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int mx = 1;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int[] a : dirs) {
            int x = i + a[0];
            int y = j + a[1];
            if (x < 0 || x >= m || y < 0 || y >=n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, dp, x, y);
            mx = Math.max(mx, len);
        }
        dp[i][j] = mx;
        return mx;
    }
}
// @lc code=end

