/*
 * @lc app=leetcode.cn id=1254 lang=java
 *
 * [1254] 统计封闭岛屿的数目
 */

// @lc code=start
class Solution {
    private int valid = 0;
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) continue;
                valid = 1;
                dfs(grid, j, i, n, m);
                ans += valid;
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            valid = 0;
            return;
        }
        if (grid[y][x] == 1) return;
        grid[y][x] = 1;
        dfs(grid, x+1, y, n, m);
        dfs(grid, x-1, y, n, m);
        dfs(grid, x, y+1, n, m);
        dfs(grid, x, y-1, n, m);
    }

}
// @lc code=end

