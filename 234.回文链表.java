/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public ListNode root;
    public boolean isPalindrome1(ListNode head) {
        // fast/slow指针
        // ListNode fast = head;
        // ListNode slow = head;
        // while (fast != null && fast.next != null) {
        //     fast = fast.next.next;
        //     slow = slow.next;
        // }
        // if (fast != null) {
        //     slow = slow.next;
        // }
        // slow = reverse(slow);
        // while (slow != null) {
        //     if (slow.val != head.val) {
        //         return false;
        //     }
        //     slow = slow.next;
        //     head = head.next;
        // }
        // return true;
        root = head;
        return (head == null) ? true : _isPalindrome(head);
    }

    public boolean _isPalindrome(ListNode head) {
        boolean flag = true;
        System.out.print(head.val);
        if (head.next != null) {
            flag = _isPalindrome(head.next);
        }
        if (flag && root.val == head.val) {
            root = root.next;
            return true;
        }
        return false;
    }

    // 翻转链表
    private ListNode reverse(ListNode head) {
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

    // 先把链表存到栈中, 再一个个比较
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        Stack<Integer> st = new Stack<>();
        while (cur != null) {
            st.push(cur.val);
            cur = cur.next;
        }

        while (head != null) {
            int t = st.pop();
            if (t != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
// @lc code=end

