/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */

// @lc code=start
class Solution {
    public int[][] imageSmoother(int[][] M) {
        if(M.length == 0 || M[0].length == 0) return null;
        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                int cnt = M[i][j];
                int all = 1;
                for (int k = -1; k < 2; k++) {
                    for (int h = -1; h < 2; h++) {
                        if (k == 0 && h == 0) continue;
                        int x = i + k;
                        int y = j + h;
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        ++all;
                        cnt += M[x][y];
                    }
                }
                res[i][j] = cnt / all;
            }
        }
        return res;
    }
}
// @lc code=end

