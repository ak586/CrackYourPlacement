package day24.reverseLinkedList2;

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
    void print(ListNode head){
        if(head==null) return ;
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;
        ListNode front=null;
        ListNode tempHead=head;
        int i=1;
        ListNode curr=head;
        // find correct nodes using their postions
        while(i<right){
            if(i==left-1){
                front=curr;
            }
            if(i==left){
                tempHead=curr;
            }
            ++i;
            curr=curr.next;
        }

        ListNode back=curr.next; // remaining end part to be attached at the tail of the reversed node
        if(curr!=null)
        curr.next=null;
        // reverse left to right
        ListNode prev=null;
        curr=tempHead;
        ListNode next=tempHead;
        while(next!=null){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // join different parts 
        tempHead.next=back;
        if(front!=null ) front.next=prev;
        else{
            head=prev;
        }
        return head;
    }
}
