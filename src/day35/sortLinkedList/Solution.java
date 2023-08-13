package day35.sortLinkedList;

class Solution
{
    
    static Node sort(Node head){
        if(head==null || head.next==null) return head ;
        
        Node temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        
        int mid=len/2;
        
        if(len%2!=0) mid++;
        temp=head;
        
        for(int i=1; i<mid; i++){
            temp=temp.next;
        }
        
        Node h1=head;
        Node h2=temp.next;
        temp.next=null;
        
        Node p1=sort(h1);
        Node p2=sort(h2);
        Node ans=merge(p1, p2);
        return ans;
    }
    

    static Node merge(Node h1, Node h2)
    {
        if(h1==null) return h2;
        if(h2==null) return h1;
        
        Node ans=new Node (-1);
        Node ansHead=ans;
        while(h1!=null && h2!=null){
            if(h1.data<h2.data){
                Node next=h1.next;
                h1.next=null;
                ans.next=h1;
                h1=next;
            }
            else{
                Node next=h2.next;
                h2.next=null;
                ans.next=h2;
                h2=next;
            }
            ans=ans.next;
        }
        
        if(h1!=null) ans.next=h1;
        if(h2!=null) {
            ans.next=h2;
        }
        Node temp=ansHead.next;
        ansHead.next=null;
        return temp;
        
    }
    
    static Node mergeSort(Node head){
        return sort(head);
    }
}
