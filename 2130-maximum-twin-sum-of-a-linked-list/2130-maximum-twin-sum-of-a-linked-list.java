/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        if(head == null){
            return 0;
        }
        ListNode middle = findMiddle(head);
        ListNode head1 = reverse(middle);
        int max = 0;
        int sum = 0;
        while(head != null && head1 != null){
            sum = head.val + head1.val;
            max = Math.max(sum,max);
            head = head.next;
            head1 = head1.next;
        }
        return max;
    }
    static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}