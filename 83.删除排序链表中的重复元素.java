/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    // 遍历法
    // public ListNode deleteDuplicates(ListNode head) {
    //     ListNode cur = head;
    //     while(cur != null &&  cur.next != null) {
    //         if (cur.val == cur.next.val) {
    //             cur.next = cur.next.next;
    //         } else {
    //             cur = cur.next;
    //         }
    //     }
    //     return head;
    // }
    // 递归 recursion
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
          return head;
        }
        head.next = deleteDuplicates(head.next);
        return (head.val == head.next.val) ? head.next : head;
    }
}
// @lc code=end

