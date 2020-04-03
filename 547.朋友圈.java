/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length, res = 0;
        if (n == 0) return 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            helper(M, i, visited);
            ++res;
        }
        return res;
    }

    private void helper(int[][] M, int k, boolean[] visited) {
        visited[k] = true;
        for (int i = 0; i < M.length; i++) {
            if (M[k][i] == 0 || visited[i]) continue;
            helper(M, i, visited);
        }
    }

    public int findCircleNum1(int[][] M) {
        int n = M.length;
        if (n == 0) return 0;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (M[i][i] == 0) continue;            
            ++ans;
            System.out.println(i);
            dfs(M, i, n);
        }
        return ans;
    }

    private void dfs(int[][] M, int curr, int n) {
        for (int i = 0; i < n; ++i) {
            if (M[curr][i] == 0) continue;
            M[curr][i] = M[i][curr] = 0;
            dfs(M, i, n);
        }
    }
}
// @lc code=end
