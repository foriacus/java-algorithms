import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Solution {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '6') {
                String ret = s.substring(0, i) + '9' + s.substring(i+1);
                return Integer.valueOf(ret);
            }
        }
        return num;
    }
    public int maximum69Number1(int num) {
        // 全扔到stack里
        Stack<Integer> q = new Stack<>();
        int ratio = 1;
        while (num > 0) {
            q.add(num % 10);
            num /= 10;
            ratio *= 10;
        }
        int res = 0;
        boolean changed = false;
        while (!q.isEmpty()) {
            int top = q.peek();
            q.pop();
            System.out.println(top);
            if (!changed && top == 6) {
              changed = true;
              top = 9;
            }
            ratio /= 10;
            res += top * ratio;
        }
        return res;
    }
}
// @lc code=end

