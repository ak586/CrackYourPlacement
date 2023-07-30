package day21.palindromeLinkedList;

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode prev=null;
        ListNode curr=slow;
        ListNode next=slow;
        while(next!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        while(prev!=null && head!=null){
            if(head.val!=prev.val) return false;
            head=head.next;
            prev=prev.next;
        }
        return true;

        
        
    }
}
