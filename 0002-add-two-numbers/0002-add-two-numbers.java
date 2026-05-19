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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int sum = 0;
        int carry = 0;
        ListNode temp = new ListNode(0);
        ListNode ansHead = temp;
        while(l1 != null || l2 != null){
          sum = carry;
          if(l1 != null){
            sum += l1.val;
            l1 = l1.next;
          }
          if(l2 != null){
            sum += l2.val;
            l2 = l2.next;
          }
          ListNode newNode = new ListNode(sum%10);
          carry = sum/10;
          temp.next = newNode;
          temp = newNode;
        }
        if(carry != 0){
            ListNode lastNode = new ListNode(carry);
            temp.next = lastNode;
        }
        return ansHead.next;
    }
}