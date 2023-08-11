package day33.bTreeToDLL;

class Solution
{
    static Node prev;
    static Node head;
    void helper(Node root){
        if(root==null) return ;
        helper(root.left);
        if(prev==null){
            head=root;
        }
        else{
            prev.right=root;
            root.left=prev;
        }
        prev=root;
        helper(root.right);
    }
    Node bToDLL(Node root)
    {
        prev=null;
        head=null;
       helper(root);
       return head;
    }
}
