/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        // Use a stack to track the index of all unmatched open parentheses.
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    int index = stack.peek();
                    stack.pop();
                    ans = Math.max(ans, stack.isEmpty() ? i - start + 1 : i - stack.peek());
                }
            }
        }
        return ans;
    }
}
// @lc code=end

