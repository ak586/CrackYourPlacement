package day17.binaryTreePaths;

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
    static List<String>ans;
    public void helper(TreeNode root, String currPath){
        if(root==null){
            return ;
        }
        String currVal=Integer.toString(root.val);
        if(currPath.length()!=0) currVal="->"+currVal;
        currPath+=currVal;
        helper(root.left, currPath);
        helper(root.right, currPath);
        if(root.left==null && root.right==null) {
            if(currPath.length()>0) ans.add(currPath);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ans=new ArrayList<>();
        helper(root,"");
        return ans;
    }
}
