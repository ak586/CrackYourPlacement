package day30.reorderList;

// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

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
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=head;
        while( next!=null){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode tail=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            // for handling even number of nodes 
            if(fast==null)
            {
                tail=slow;
            }
            slow=slow.next;
        }
        // break the link otherwise it would result in cycle
        if(tail!=null) tail.next=null;
        ListNode head2=reverse(slow);
        ListNode curr=head;
        ListNode next1=head;
        ListNode next2=head2;
        while(next1!=null && next2!=null){
            next1=next1.next;
            next2=head2.next;
            head2.next=null;
            curr.next=head2;
            curr.next.next=next1;
            curr=next1;
            head2=next2;
        }
    }
}
