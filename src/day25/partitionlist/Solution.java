package day25.partitionlist;

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
    public ListNode partition(ListNode head, int x) {
        if(head==null ||head.next==null ) return head;
        ListNode less=null;
        ListNode tailLess=less;
        ListNode greater=null;
        ListNode tailGreater=null;
        ListNode curr=head;
        ListNode next=head;
        while(curr!=null){
            next=next.next;
            curr.next=null;
            if(curr.val<x){
                if(less==null) {
                    less=curr;
                    tailLess=curr;
                }
                else {
                    tailLess.next=curr;
                    tailLess=tailLess.next;
                }
            }
            else{
                if(greater==null){
                    greater=curr;
                    tailGreater=curr;
                }
                else{
                    tailGreater.next=curr;
                    tailGreater=tailGreater.next;
                }
            }
            curr=next;

        }
    if(less==null) return head;
    else tailLess.next=greater;
    return less;

    }
}
