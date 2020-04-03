import java.util.List;

/*
 * @lc app=leetcode.cn id=1262 lang=java
 *
 * [1262] 可被三整除的最大和
 */

// @lc code=start
class Solution {
    // public int maxSumDivThree(int[] nums) {
    //     // dp[i] := max sum that has a remainder i when mod 3.
    //     int[] dp = new int[3];
        
    // }
    /**
    可以这样思考，遍历整个数组然后将数分成三个部分，%3==0、%3==1和%3==2。
    然后整个数组的和sum_all模3等于0，那么这就是最大值了。
    如果等于1，那么我们需要从%3==1的数中选一个最小的数t1，然后再从%3==2中选两个最小的数并计算和t2，比较t1和t2选择最小的，然后sum_all减去即可。
    如果等于2，那么我们需要从%3==2的数中选一个最小的数t1，然后再从%3==1中选两个最小的数并计算和t2，比较t1和t2选择最小的，然后sum_all减去即可。
    */
    public int maxSumDivThree(int[] nums) {
        List<Integer> b0 = new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        List<Integer> b2 = new ArrayList<>();

        int sum_all = 0;
        for (int num : nums) {
            if (i % 3 == 0) {
                b0.add(num);
            } else if (i % 3 == 1) {
                b1.add(num);
            } else {
                b2.add(num);
            }
            sum += num;
        }
        if (sum_all % 3 == 0) {
            return sum_all;
        } else if (sum_all % 3 == 1) {
            int t1 = 0;
            int t2 = 0;

        } else {
            int t1 = 0;
            int t2 = 0;
        }
    }
// @lc code=end

