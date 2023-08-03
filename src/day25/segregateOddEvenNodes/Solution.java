package day25.segregateOddEvenNodes;

class Solution{
    Node divide(int N, Node head){
        if(head==null|| head.next==null) return head;
       Node eHead=null;
       Node eTail=null;
       Node oHead=null;
       Node oTail=null;
       Node curr=head;
       Node next=head;
       while(curr!=null){
           next=next.next;
          
           curr.next=null;
           if(curr.data%2==0){
            // System.out.println(curr.data);
               if(eHead==null){
                   eHead=curr;
                   eTail=curr;
               }
               else{
                   eTail.next=curr;
                   eTail=eTail.next;
               }
           }
           else{
               if(oHead==null){
                   oHead=curr;
                   oTail=curr;
               }
               else{
                   oTail.next=curr;
                   oTail=oTail.next;
               }
           }
           curr=next;
       }
       
       if(eHead!=null){
           eTail.next=oHead;
           return eHead;
       } 
       else return oHead;
    }
}
