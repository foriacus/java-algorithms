import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //  bfs
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 0; i < m ; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    q.add(new Integer[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        /**
         * 从queue中取出一个数字，遍历其周围四个点，如果越界或者周围点的值小于等于当前值加1，则直接跳过。
         * 因为周围点的距离更小的话，就没有更新的必要，否则将周围点的值更新为当前值加1，然后把周围点的坐标加入queue
         */
        
        while (!q.isEmpty()) {
            Integer[] t = q.poll();
            for (int[] dir : dirs) {
                int x = t[0] + dir[0];
                int y = t[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[t[0]][t[1]] + 1) {
                    continue;
                }
                matrix[x][y] = matrix[t[0]][t[1]] + 1;
                q.add(new Integer[]{x, y});
            }
        }
        return matrix;
    }
}
// @lc code=end

