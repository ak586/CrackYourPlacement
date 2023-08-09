package day31.mergeKSortedLists;

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
    // brute force keep merging two nodes
    public ListNode merge(ListNode h1,ListNode h2 ){
        if(h1==null ) return h2;
        if(h2==null) return h1;
        ListNode dummy=new ListNode (-1);
        ListNode dummyHead=dummy;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                ListNode temp=h1;
                h1=h1.next;
                temp.next=null;
                dummy.next=temp;
            }
            else{
                ListNode temp=h2;
                h2=h2.next;
                temp.next=null;
                dummy.next=temp;
            }
            dummy=dummy.next;
        }
        if(h1!=null) dummy.next=h1;
        if(h2!=null) dummy.next=h2;
        return dummyHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // optimised solution O(N*logK)
        // keep adding current minimum element to the ans
        ListNode ans=new ListNode(-1);
        ListNode ansHead=ans;
        int n=lists.length;
        PriorityQueue<ListNode>minHeap=new PriorityQueue<>((a,b)->(a.val-b.val));
        for(int i=0; i<n; i++){
            if(lists[i]!=null) minHeap.add(lists[i]);
        }
        while(!minHeap.isEmpty()){
            ListNode min=minHeap.poll();
            ans.next=min;
            ans=ans.next;
            min=min.next;
            if(min!=null)
                minHeap.add(min); 
        }
        // this is by merging two linked list at a time
        // for(int i=0; i<n; i++){
        //     ans=merge(ans, lists[i]);
        // }
        // return ans;
        return ansHead.next;
    }
}
