package day30.binaryTreeMaximumPathSum;

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
    static int maxi;
    public int helper( TreeNode root ){
        if(root==null) return 0;
        int lf=Math.max(0,helper(root.left));
        int rg=Math.max(0,helper(root.right));
        maxi=Math.max(maxi,lf+rg+root.val);
        return root.val+ Math.max(lf, rg);
    }
    public int maxPathSum(TreeNode root) {
        maxi=Integer.MIN_VALUE;
        helper(root);
        return maxi;

    }
}
