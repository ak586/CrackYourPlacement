package day32.kthSmallestInBST;

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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        while (curr != null) {
            TreeNode leftNode = curr.left;
            if (leftNode == null) {
                k--;
                if (k == 0)
                    return curr.val;
                curr = curr.right;
            } else {
                TreeNode rightMost = findRightMost(leftNode, curr);
                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                } else {
                    rightMost.right = null;
                    k--;
                    if (k == 0)
                        return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
    
    TreeNode findRightMost(TreeNode leftNode, TreeNode curr){
        while(leftNode.right!=null && leftNode.right!=curr){
            leftNode=leftNode.right;
        }
        return leftNode;
    }
}
