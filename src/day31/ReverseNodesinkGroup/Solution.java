package day31.ReverseNodesinkGroup;

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
    // method to reverse k nodes in groups
    ListNode rev(ListNode head, int k){
        ListNode curr=head;
        ListNode next=curr;
        ListNode prev=null;
        int count=0;
        ListNode temp=head;
        int i=0;
        // check if there are k nodes available or not
        while(temp!=null && i<k){
            i++;
            temp=temp.next;
        }
        if(i!=k) return curr;
        while(curr!=null && count<k){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        ListNode next=head;
        ListNode curr=head;
        while(curr!=null){
            // after reversal this will become tail use it as tail
            ListNode temp=curr;
            int i=0;
            for(; i<k ; i++){
                if(next==null) break;
                next=next.next;
            }
            ListNode reversed=rev(curr,k);
            dummy.next=reversed;
            // move dummy to tail
            dummy=temp;
            curr=next;
        }
        return ans.next;
    }
}
