package day24.validateBST;

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
    public boolean isValidBST(TreeNode root, long min, long max){
        if(min>=max) return false;
        if(root==null) return true;
        boolean leftBST=isValidBST(root.left, min, root.val);
        boolean  rightBST=isValidBST(root.right, root.val, max);
        return root.val>min && root.val <max && leftBST && rightBST;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
