/*
 * @lc app=leetcode.cn id=1209 lang=java
 *
 * [1209] 删除字符串中的所有相邻重复项 II
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s, int k) {
        // stack
        Stack<Pair> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == ch) {
                stack.peek().freq++;
            } else {
                stack.push(new Pair(ch, 1));
            }
            if (stack.peek().freq == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Pair cur = stack.pop();
            for (int i = 0;i < cur.freq; i++) {
                sb.append(cur.c);
            }
        }
        return sb.reverse().toString();
    }

    class Pair {
        char c;
        int freq;
        
        public Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
// @lc code=end

