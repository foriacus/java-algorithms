import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> res = new Stack<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (k > 0 && !res.isEmpty() && res.peek() > c) {
                res.pop();
                --k;
            }
            if (!res.isEmpty() || c != '0') {
                res.push(c);
            }
        }
        while (!res.isEmpty() && k > 0) {
            --k;
            res.pop();
        }
        if (!res.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i));
            }
            return sb.toString();
        }
        return "0";
    }
}
// @lc code=end

