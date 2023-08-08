package day30.zigZigLinkedList;

class Solution{
    // brute force will be to sort the linked list and swap adjacent nodes
    public static Node zigZag(Node head) {
        // optimised solution
	   //  handle only even positioned nodes
	    if(head==null || head.next==null ) return head;
        Node prev=head;
        Node curr=head.next;
        Node next=head.next;
        while(curr!=null){
            next=null;
            if(curr.next!=null)
                next=curr.next;
            if(prev.data>curr.data){
                int temp=curr.data;
                curr.data=prev.data;
                prev.data=temp;
            }
            
            if(next!=null)
            {
                if(next.data>curr.data){
                    int temp=curr.data;
                    curr.data=next.data;
                    next.data=temp;
                }
            }
            
            prev=curr.next;
            // skip one node in between 1-> 2-> 3->4  process only evenly positionded elements s
            if(curr.next!=null)
            curr=curr.next.next;
            else curr=curr.next;
        }
        
        return head;
    }
}
