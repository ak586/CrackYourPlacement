package day21.minimumAbsoluteDifferenceInBST;

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

//  Inorder traverses a BST in sorted order. Minimum diffrence will between two consecutive elements
class Solution {
    static TreeNode prev;
    static int ans;
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        if(prev!=null){
            ans=Math.min(ans, Math.abs(root.val-prev.val));
        }
        prev=root;
        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        prev=null;
        ans=Integer.MAX_VALUE;
        inorder(root);
        return ans;
    }
}
