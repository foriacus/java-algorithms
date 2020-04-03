import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    int N;
    List<List<Integer>> list;
    Stack<Integer> path;
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        // dfs
        N = nums.length;
        list = new ArrayList<List<Integer>>();
        path = new Stack<Integer>();
        used = new boolean[N];

        dfs(nums, 0);
        return list;
    }

    private void dfs(int[] nums, int d) {
        // stop condition
        if (d == N) {
            list.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                path.push(nums[i]);
                
                dfs(nums, d + 1);
                path.pop();
                used[i] = false;
            }
        }
    }
}
// @lc code=end

