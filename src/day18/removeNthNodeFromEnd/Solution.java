package day18.removeNthNodeFromEnd;

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
        ListNode slow=head;
        ListNode fast=head;
        int i = 0;
        // for handling edge case in which the node to be deleted is the last node
        ListNode prev=null;
        if (head == null || head.next == null)
            return null;
        
        while(fast!=null && i<n){
            prev=fast;
            fast=fast.next;
            ++i;
        }
        while(fast!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        if(slow.next==null) {
          prev.next=null;
        }
        else{
            slow.val=slow.next.val;
            slow.next=slow.next.next;
        }
        
        return head;
    }
}
