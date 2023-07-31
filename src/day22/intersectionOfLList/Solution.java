package day22.intersectionOfLList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//  remove extra length and start the traversal with same length
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA;
        int lenA=0;
       while(l1!=null){
           l1=l1.next;
           lenA++;
       }
       ListNode l2=headB;
       int lenB=0;
       while(l2!=null){
           l2=l2.next;
           ++lenB;
       }
       
       if(lenA>lenB){
           while(lenA<lenB){
               headA=headA.next;
               lenA--;
           }
       }
       else{
           while(lenA<lenB){
               headB=headB.next;
               lenB--;
           }
       }
       while(headA!=null && headB!=null){
           if(headA==headB) return headA;
           headA=headA.next;
           headB=headB.next;
       }
       return null;
    }
}
