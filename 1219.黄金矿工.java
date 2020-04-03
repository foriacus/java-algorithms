/*
 * @lc app=leetcode.cn id=1219 lang=java
 *
 * [1219] 黄金矿工
 */

// @lc code=start
class Solution {
    private int res = 0;
    private int[][] dirs = new int [][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    res = Math.max(res, dfs(grid, i, j, m, n));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        int max = 0;
        for (int[] dir : dirs) {
            max = Math.max(max, dfs(grid, i + dir[0], j + dir[1], m, n));
        }
        grid[i][j] = temp;
        return temp + max;
    }
}
// @lc code=end

