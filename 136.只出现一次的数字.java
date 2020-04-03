import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for (int num : nums) {
        //     if (map.containsKey(num)) {
        //         map.put(num, map.get(num) + 1);
        //     } else {
        //         map.put(num, 1);
        //     }
        // }
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() == 1) return entry.getKey();
        // }
        // return 0;

        // List<Integer> list = new LinkedList<>();
        // for (int num : nums) {
        //     if (list.contains(num)) {
        //         list.remove(list.indexOf(num));
        //     } else {
        //         list.add(num);
        //     }
        // }
        // if (list.size() > 0) {
        //   return list.get(0);
        // }
        // throw new ArrayIndexOutOfBoundsException("Not found");

        // int res= 0;
        // for (int num : nums) {
        //     res ^= num;
        // }
        // return res;

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        for (int i : set) {
            return i;
        }
        return -1;
    }
}
// @lc code=end

