package day32.flattenABinaryTree;


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
    // brute force O(n) time and O(1) space
    static TreeNode head;
    void revPreorder(TreeNode root){
        if(root==null) return ;
        revPreorder(root.right);
        revPreorder(root.left);
        root.left=null;
        root.right=head;
        head=root;
    }
    public void flatten(TreeNode root) {
        // head=null;
        // revPreorder(root);
        // using morris traversal
        // optimised solution using morris traversal
        // connect rightMost node of curr.left to curr.right 
        TreeNode curr=root;
        while(curr!=null){
            TreeNode leftNode=curr.left;
            if(leftNode==null){
                curr=curr.right;
            }
            else{
                TreeNode rightMost=findRightMost(leftNode);
                rightMost.right=curr.right;
                TreeNode temp=curr.left;
                curr.left=null;
                curr.right=temp;
                curr=curr.right;
            }
        }
    }

    TreeNode findRightMost(TreeNode leftNode){
        while(leftNode.right!=null) {
            leftNode=leftNode.right;
        }
        return leftNode;
    }
}