// Definition for singly-linked list.
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers2(l1, l2, 0);
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            } else {
                return new ListNode(1);
            }
        }
        if (l1 == null) {
            ListNode curr = l2;
            ListNode prev = null;
            while (carry == 1) {
                if (curr == null) {
                    prev.next = new ListNode(1);
                    break;
                }
                int val = curr.val + carry;
                curr.val = val % 10;
                carry = val / 10;
                prev = curr;
                curr = curr.next;
            }
            return l2;
        }
        if (l2 == null) {
            ListNode curr = l1;
            ListNode prev = null;
            while (carry == 1) {
                if (curr == null) {
                    prev.next = new ListNode(1);
                    break;
                }
                int val = curr.val + carry;
                curr.val = val % 10;
                carry = val / 10;
                prev = curr;
                curr = curr.next;
            }
            return l1;
        }
        ListNode result = new ListNode(0);
        int val = l1.val + l2.val + carry;
        result.val = val % 10;
        carry = val / 10;
        result.next = addTwoNumbers2(l1.next, l2.next, carry);
        return result;
    }
}
\\79.76
