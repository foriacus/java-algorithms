import java.util.List;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    // 递归解法
    // private ListNode reverseListIncursion(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     } else {
    //         ListNode newHead = reverseListIncursion(head.next);
    //         head.next.next = head;
    //         head.next == null;
    //         return newHead;
    //     }
    // }

    // 遍历法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
// @lc code=end

