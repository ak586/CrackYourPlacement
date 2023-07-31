package day22.addTwoNumbers2;

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
// method 1 reverse the list
// method 2 use stack 
// method 3 Transfer the carry to previous node 

class Solution {
    boolean foundSum(ListNode ans){
        ListNode temp=ans;
        while(temp!=null){
            if(temp.val/10!=0) return false;
            temp=temp.next;
        }
        return true;

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=0;
        int len2=0;
        ListNode temp=l1;
        while(temp!=null){
            ++len1;
            temp=temp.next;
        }
        ListNode temp2=l2;
        while(temp2!=null){
            ++len2;
            temp2=temp2.next;
        }
        ListNode ans=l1;
        int flag=1;
        if(len2>len1){
            ans=l2;
            flag=2;
        } 
        while(len1>len2){
            ans=ans.next;
            --len1;
        }
        while(len2>len1){
            ans=ans.next;
            --len2;
        }

         temp=l1;
         temp2=l2;
        while(ans!=null){

            if(flag==1)  {
                ans.val=ans.val+l2.val;
                l2=l2.next;
            }
            else {
                ans.val=ans.val+l1.val;
                l1=l1.next;
            }
            ans=ans.next;
        }
        if(flag==1) ans=l1;
        if(flag==2) ans=l2;
        while(true){
        ListNode curr=ans;
        ListNode prev=null;
            while(curr!=null){
                if(curr.val/10!=0){
                    int carry=curr.val/10;
                    curr.val=curr.val%10;
                    if(prev==null){
                        ListNode t=new ListNode (carry);
                        t.next=ans;
                        ans=t;
                    }else{
                        prev.val+=carry;
                    }
                }
                prev=curr;
                curr=curr.next;
            }
            if(foundSum(ans)) break;
        }
     return ans;
    }
}
