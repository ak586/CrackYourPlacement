package day16.removeDuplicatesFromSortedLL;

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
        ListNode temp=head;
        ListNode ans=head;
        while(temp!=null){
            while(temp!=null && temp.val==ans.val){
                temp=temp.next;
            }
            ans.next=temp;
            ans=ans.next;
        }
        return head;
    }
}
