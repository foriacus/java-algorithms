import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public ListNode middleNode(ListNode head) {
    //     // 方法一 将所有的结点按顺序存入到一个数组中，那么之后就可以直接根据坐标位置来访问结点了
    //     ArrayList<ListNode> list = new ArrayList<>();
    //     int cur = 0;
    //     while (head != null) {
    //         list.add(head);
    //         cur++;
    //         head = head.next;
    //     }
    //     return list.get(cur / 2);
    // }

    // 方法二 快慢指针
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null &&  fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
// @lc code=end

