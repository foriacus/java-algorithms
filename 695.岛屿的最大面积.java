/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;

        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ans = Math.max(ans, area(grid, j, i, w, h));
            }
        }
        return ans;
    }

    private int area(int[][] grid, int x, int y, int w, int h) {
        if (x < 0 || y < 0 || x >= w || y >= h || grid[y][x] == 0) {
            return 0;
        }
        grid[y][x] = 0;
        return area(grid, x - 1, y, w, h)
            + area(grid, x + 1, y, w, h)
            + area(grid, x, y - 1, w, h)
            + area(grid, x, y + 1, w, h)
            + 1;
    }
}
// @lc code=end

