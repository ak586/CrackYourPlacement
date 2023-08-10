package day32.recoverBinarySearchTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    static TreeNode prev;
    static TreeNode a;
    static TreeNode b;
    static TreeNode c;
    static TreeNode d;
    // inorder O(n) and O(h)
    public void inorder(TreeNode curr){
        if(curr==null)return ;
        inorder(curr.left);
        if(prev!=null){ 
            if(prev.val>curr.val){
                if(a==null){
                    a=prev;
                    b=curr;
                }
                else{
                    c=prev;
                    d=curr;
                }
            }
        }
        prev=curr;
        inorder(curr.right);
    }



    public void recoverTree(TreeNode root) 
    {   prev=null;

        // (a,b) first ambiguity points the larger value is came back so larger value is misplaced
        a=null;
        b=null;
        // (c,d) second ambiguity point here smaller value came from front so smaller value is misplaced
        c=null;
        d=null;
        // inorder(root);

        // doing it via morris traversal in O(1) space
        TreeNode curr=root;
        while(curr!=null){
            TreeNode leftNode=curr.left;
            if(leftNode==null){
                // process current node
                if(prev!=null){ 
                    if(prev.val>curr.val){
                        if(a==null){
                             a=prev;
                             b=curr;
                            }else{
                                c=prev;
                                d=curr;
                            }
                    }
                }
            prev=curr;
            curr=curr.right;
            }else{
                    TreeNode rightMost=findRightMost(leftNode, curr);
                    // create a thread
                    if(rightMost.right==null){
                        rightMost.right=curr;
                        curr=curr.left;
                    }
                    else{
                        rightMost.right=null;
                        if(prev!=null){ 
                                if(prev.val>curr.val){
                                        if(a==null){
                                            a=prev;
                                            b=curr;
                                        }else{
                                            c=prev;
                                            d=curr;
                                            }
                                        }
                                }
                        prev=curr;
                        curr=curr.right;
                    }
                }
            }

        if(d!=null){
            int temp=d.val;
            d.val=a.val;
            a.val=temp;
        }else{
            int temp=a.val;
            a.val=b.val;
            b.val=temp;
        }
        
        }

    TreeNode findRightMost(TreeNode leftNode, TreeNode curr){
        while(leftNode.right!=null && leftNode.right!=curr){
            leftNode=leftNode.right;
        }
        return leftNode;
    }

}
