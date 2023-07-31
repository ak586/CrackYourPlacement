package day22.copyWithRandomPointer;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // Brute force : O(n^2) and O(1) space
    public Node helper(Node head) {
        if(head==null) return head;
        Node ans=null;
        Node tail=ans ;
        Node temp=head;
        while(temp!=null){
            Node curr=new Node(temp.val);
            if(tail==null){
                ans=curr;
                tail=curr;
            }else{
                tail.next=curr;
                tail=tail.next;
            }
            temp=temp.next;
        }

        tail=ans;
        temp=head;
        while(tail!=null){
            if(temp.random==null){
                tail.random=null;
            }
            else{
                Node start=head;
                int len=0;
                while(start!=temp.random){
                    ++len;
                    start=start.next;
                }
                Node curr=ans;
                while(len!=0){
                    --len;
                    curr=curr.next;
                }
                tail.random=curr;
            }
            tail=tail.next;
            temp=temp.next;
        }
        return ans;
    }

    // using hashMap O(n) with O(n) space
    public Node helper2(Node head){
        HashMap<Node , Node> map=new HashMap<>();
        Node ans=null;
        Node tail=ans ;
        Node temp=head;
        // create copy of linked list with next nodes 
        while(temp!=null){
            Node curr=new Node(temp.val);
            if(tail==null){
                ans=curr;
                tail=curr;
            }else{
                tail.next=curr;
                tail=tail.next;
            }
            temp=temp.next;
        }
        tail=ans;
        temp=head;
        while(tail!=null){
            map.put(temp, tail);
            tail=tail.next;
            temp=temp.next;
        }
        tail=ans;
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                tail.random=map.get(temp.random);
            }
            tail=tail.next;
            temp=temp.next;
        }
        return ans;
        
    }

// most optimised O(n) and constant space
    public Node copyRandomList(Node head){
        if(head==null) return null;
        Node curr=head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=new Node(curr.val);
            curr.next.next=next;
            curr=next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null)
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }

        
        Node original=head;
        Node copy=head.next;
        Node ans=copy;
        while(original!=null){
            original.next=original.next.next;
            if(copy.next!=null)
            copy.next=copy.next.next;
            copy=copy.next;
            original=original.next;
        }
        return ans;

    }



    
}
