package day21.sumOfLeftLeafNodes;

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
    public int helper(TreeNode root, boolean isLeft){
        if(root==null) return 0;
        int ansLeft=helper(root.left,true);
        int ansRight=helper(root.right, false);
        if(isLeft==true && root.left==null && root.right==null) return ansLeft+ansRight+root.val;
        else return ansLeft+ansRight;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
}
