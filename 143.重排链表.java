/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        Stack<ListNode> st = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            st.push(cur);
            cur = cur.next;
        }

        int cnt = (st.size() - 1 ) / 2;
        cur = head;
        while (cnt-- > 0) {
            ListNode t = st.peek();
            st.pop();
            ListNode next = cur.next;
            cur.next = t;
            t.next = next;
            cur = next;
        }
        st.peek().next = null;
    }
}
// @lc code=end

