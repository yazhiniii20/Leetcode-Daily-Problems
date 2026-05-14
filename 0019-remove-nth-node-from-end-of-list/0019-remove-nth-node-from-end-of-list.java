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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if(head == null || head.next == null){
            return null;
        }
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        int pos = length-n;
        if(pos == 0){
            ListNode curr = head;
            head = head.next;
            curr.next = null;
            return head;
        }
        int i = 1;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow.next != null && fast.next != null){
            if(i == pos){
                break;
            }
            slow = slow.next;
            fast = fast.next;
            i++;
        }
        slow.next = fast.next;
        return head;
    }
}