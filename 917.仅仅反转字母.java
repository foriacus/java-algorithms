/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        while (i < j) {
            if (Character.isLetter(S.charAt(i)) && Character.isLetter(S.charAt(j))) {
                S = swap(S, i, j);
                ++i;
                --j;
            } else {
                if (!Character.isLetter(S.charAt(i))) ++i;
                if (!Character.isLetter(S.charAt(j))) --j;
            }
        }
        return S;
    }

    private String swap(String S, int i, int j) {
        StringBuilder sb = new StringBuilder(S); 
        sb.setCharAt(i, S.charAt(j)); 
        sb.setCharAt(j, S.charAt(i)); 
        return sb.toString();
    }
}
// @lc code=end
