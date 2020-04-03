import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] range = intervals[0];
        int left = range[0];
        int right = range[1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= right) {
                right = Math.max(right, interval[1]);
            } else {
                int[] newArray = {left, right};
                result.add(newArray);

                left = interval[0];
                right = interval[1];
            }
        }
        int[] newArray = {left, right};
        result.add(newArray);
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

