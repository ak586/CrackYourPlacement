package day17.sameTree;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null) return p==q;
        boolean lSame=isSameTree(p.left,q.left);
        boolean rSame=isSameTree(p.right, q.right);
        return p.val==q.val && lSame && rSame;
    }
}
