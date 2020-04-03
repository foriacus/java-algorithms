import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    // List<String> res;
    // HashMap<String, String> map;
    
    // public List<String> letterCombinations(String digits) {
    //     // 构造Map
    //     map = new HashMap<>();
    //     map.put("0", " ");
    //     map.put("1", "");
    //     map.put("2", "abc");
    //     map.put("3", "def");
    //     map.put("4", "ghi");
    //     map.put("5", "jkl");
    //     map.put("6", "mno");
    //     map.put("7", "pqrs");
    //     map.put("8", "tuv");
    //     map.put("9", "wxyz");
    //     // 
    //     res = new ArrayList<String>();
    //     if (digits.length() != 0) {
    //         helper(digits, "");
    //     }
    //     return res;
    // }

    // private void helper(String digits, String cur) {
    //     if (digits.length() == 0) {
    //         res.add(cur);
    //     } else {
    //         String digit = digits.substring(0, 1);
    //         String letters = map.get(digit);

    //         for (int i = 0; i < letters.length(); i++) {
    //             String letter = letters.substring(i, i+1);
    //             helper(digits.substring(1), cur + letter);
    //         }
    //     }
    // }

    // dfs
    // public List<String> letterCombinations(String digits) {
    //     String[] map = new String[] {
    //         " ",
    //         "",
    //         "abc",
    //         "def",
    //         "ghi",
    //         "jkl",
    //         "mno",
    //         "pqrs",
    //         "tuv",
    //         "wxyz"
    //     };
    //     char[] cur = new char[digits.length()];
    //     List<String> res = new ArrayList<>();
    //     dfs(digits, map, 0, cur, res);
    //     return res;
    // }

    // private void dfs(String digits, String[] map, int len, char[] cur, List<String> res) {
    //     if (len == cur.length) {
    //         if (len > 0) res.add(new String(cur));
    //         return;
    //     }

    //     String letters = map[Character.getNumericValue(digits.charAt(len))];
    //     for (int i = 0; i < letters.length(); i++) {
    //         cur[len] = letters.charAt(i);
    //         dfs(digits, map, len + 1, cur, res);
    //     }
    // }

    // bfs
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        String[] map = new String[] {
                    " ",
                    "",
                    "abc",
                    "def",
                    "ghi",
                    "jkl",
                    "mno",
                    "pqrs",
                    "tuv",
                    "wxyz"
                };

        List<String> res = new ArrayList<>();
        res.add("");
        for (char digit : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String t : res) {
                String letters = map[Character.getNumericValue(digit)];
                for (int i = 0; i < letters.length(); i++) {
                    tmp.add(t + letters.charAt(i));
                }
            }
            res = tmp;
        }

        return res;
    }
    
}
// @lc code=end

