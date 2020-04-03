/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>(); 
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i) {
            K += (i >= 0 ? A[i] : 0);
            res.add(K % 10);
            K /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

