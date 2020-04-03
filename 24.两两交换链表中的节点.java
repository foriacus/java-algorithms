/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    // 递归--- 回溯，递归遍历到链表末尾，然后先交换末尾2个，然后依次往前交换
    // public ListNode swapPairs(ListNode head) {
    //     if (head == null || head.next == null) return head;
    //     ListNode t = head.next;
    //     head.next = swapPairs(head.next.next);
    //     t.next = head;
    //     return t;
    // }

    public ListNode swapPairs(ListNode head) {
        
    }
}
// @lc code=end

