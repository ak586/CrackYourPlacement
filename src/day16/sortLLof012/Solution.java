package day16.sortLLof012;

//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node temp=head;
        int zero=0;
        int one=0;
        int two=0;
        while(temp!=null){
            if(temp.data==0) zero++;
            else if(temp.data==1)one++;
            else two++;
            temp=temp.next;
        }
        temp=head;
        while(zero!=0)
       {
           temp.data=0;
           temp=temp.next;
           zero--;
       }
        while(one!=0)
       {
           temp.data=1;
           temp=temp.next;
           one--;
       }
        
       while(two!=0)
       {
           temp.data=2;
           temp=temp.next;
           two--;
       }
       return head;
      
    }
}

