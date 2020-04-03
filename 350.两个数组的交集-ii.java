import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] ret = new int[Math.min(len1, len2)];
        int index = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < len1; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                ret[index++] = nums2[i];
            }
        }
        return Arrays.copyOfRange(ret, 0, index);
    }
}
// @lc code=end

