/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        for (int i = 0; i < m; i++) {
            dfs(i, 0, A);
            dfs(i, n-1, A);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, A);
            dfs(m-1, j, A);
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int x, int y, int[][] A) {
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int m = A.length, n = A[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || A[x][y] == 0) {
            return;
        } 
        A[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            dfs(tx, ty, A);
        }
    }
}
// @lc code=end

