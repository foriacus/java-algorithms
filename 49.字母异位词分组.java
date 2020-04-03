import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // two-dimension res
        List<List<String>> res = new ArrayList<>();
        // map { sortedStr : index }
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : strs) {
            String sortedStr = str_sort(str);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, res.size());
                res.add(new ArrayList());
            }
            res.get(map.get(sortedStr)).add(str);
        }
        return res;

    }

    private String str_sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
// @lc code=end

