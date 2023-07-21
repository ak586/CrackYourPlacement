package day12.symmetricTree;

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
    public static boolean helper(TreeNode root1, TreeNode root2){
        if(root1==null || root2==null) return root1==root2;
        boolean a=helper(root1.left, root2.right);
        boolean b=helper(root1.right, root2.left );
        return a&&b &&(root1.val==root2.val);
    }
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
}
