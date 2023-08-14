package day36.subtractLinkedList;

class Solution
{
    static Node reverse(Node root){
        if(root==null|| root.next==null) return root;
        Node prev=null;
        Node curr=root;
        Node next=root;
        while(next!=null){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
    static int getLength(Node root){
        int l=0;
        while(root!=null){
            ++l;
            root=root.next;
        }
        return l;
    }
    static Node subLinkedList(Node l1, Node l2)
    {
        // trim trailing zeros
        while(l1!=null && l1.data==0) l1=l1.next;
        while(l2!=null && l2.data==0) l2=l2.next;
        int len1=getLength(l1);
        int len2=getLength(l2);
        
        if(len1==len2){
            Node t1=l1;
            Node t2=l2;
            
            while(t1!=null){
                if(t2.data>t1.data){
                    Node temp=l2;
                        l2=l1;
                        l1=temp;
                        break;
                }
                if(t1.data>t2.data) break;
                t1=t1.next;
                t2=t2.next;
                if(t1==null) return new Node(0);
            }
        }
        
        if(len1<len2) {
            Node temp=l2;
            l2=l1;
            l1=temp;
        }
        
        l1=reverse(l1);
        l2=reverse(l2);
        
        Node ans=new Node (-1);
        Node ansHead=ans;
        
        while(l1!=null && l2!=null){
            if(l1.data>=l2.data){
                ans.next=new Node(l1.data-l2.data);
            }
            else{
                // take borrow 
                Node temp=l1;
                temp=temp.next;
                while(temp!=null){
                    if(temp.data>0){
                        temp.data--;
                        l1.data+=10;
                        break;
                    }
                    temp.data=9;
                    temp=temp.next;
                }
                ans.next=new Node(l1.data-l2.data);
            }
        ans=ans.next;
        l1=l1.next;
        l2=l2.next;
        }
        
    if(l1!=null) ans.next=l1;
    ans=reverse(ansHead.next);
    // trim trailing zeros 00123
    while(ans!=null && ans.data==0){
        ans=ans.next;
    }
       
    return ans;
    
        
    }
}
