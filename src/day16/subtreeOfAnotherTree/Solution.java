package day16.subtreeOfAnotherTree;

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

    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root==null||subRoot==null) return subRoot==root;
        boolean l=isSame(root.left, subRoot.left);
        boolean r=isSame(root.right, subRoot.right);
        return root.val==subRoot.val && l && r;
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(subRoot.val==root.val){
            if(isSame(root, subRoot)) return true;
        } 
       boolean ans=isSubtree(root.left,subRoot)|| isSubtree(root.right,subRoot);
       return ans;
    }
}
