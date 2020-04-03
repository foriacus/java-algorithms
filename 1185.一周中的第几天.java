/*
 * @lc app=leetcode.cn id=1185 lang=java
 *
 * [1185] 一周中的第几天
 */

// @lc code=start
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] names = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] days = {31, 28 + (leapYear(year) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int sum = 0;
        for (int i = 1971; i < year; i++) {
            sum += (365 + (leapYear(i) ? 1 : 0));
        }
        for (int i = 1; i < month; i++) {
            sum += days[i - 1];
        }
        sum += day;
        // 1971年1月1日是星期五，然后对7取余
        return names[(sum + 4) % 7];
    }

    private boolean leapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}
// @lc code=end

