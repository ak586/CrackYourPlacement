package day18.deleteWithoutHeadPointer;

/*
class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/

//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
        // while(del.next!=null){
        //     del.data=del.next.data;
        //     if(del.next.next==null) break;
        //     del=del.next;
        // }
        // del.next=null;
        del.data=del.next.data;
        del.next=del.next.next;
    }
}
