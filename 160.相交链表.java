/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 具体算法为：分别遍历两个链表，得到分别对应的长度。然后求长度的差值，把较长的那个链表向后移动这个差值的个数，然后一一比较即可。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = getLen(headA), lenB = getLen(headB);
        if (lenA > lenB) {
            for (int i = 0; i < lenA- lenB; ++i) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; ++i) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return (headA != null && headB != null) ? headA : null;
    }

    private int getLen(ListNode head) {
        int cnt = 0;
        while(head != null) {
            ++cnt;
            head = head.next;
        }
        return cnt;
    }
}
// @lc code=end

