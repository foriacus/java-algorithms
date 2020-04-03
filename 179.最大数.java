import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i ++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 降序排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String str1 = a + b;
                String str2 = b + a;
                return str2.compareTo(str1);
            }
        });

        if (strs[0].charAt(0) == '0') return "0";
        String res = "";
        for (String str : strs) {
            res += str;
        }
        return res;
    }
}
// @lc code=end

