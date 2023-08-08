package day30.populatingNextPointerInFullBinaryTree;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    // make use of next pointers and do traversal level wise
    // make links between the childrens of the curr node 
    public void helper(Node root){
        if(root.left==null) return ;
        Node curr=root;
        Node next = root;
        
        while (next != null) {
            
            next = next.next;
            // make link between left and right child
            curr.left.next = curr.right;
            // link it with the next node's left childrent
            if(next!=null)
            curr.right.next=next.left;
            curr=next;
        }
        helper(root.left);
    }

    public Node connect(Node root) {
        if(root==null) return root;
        helper(root);
        return root;

    }
}
