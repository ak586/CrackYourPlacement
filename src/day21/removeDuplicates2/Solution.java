package day21.removeDuplicates2;

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode tail=head;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr;
            int count=0;
            while(temp!=null && temp.val==curr.val){
                    ++count;
                    temp=temp.next;
            }
            
            if(count==1){
                if(tail.val!=curr.val){
                    tail.next=curr;
                    tail=tail.next;
                }
                curr=temp;
            }else{
                if(head==curr){
                    head=temp;
                    tail=head;
                }
                else{
                    tail.next=temp;
                }
                curr=temp;
            }
        }
        return head;
    }
}
