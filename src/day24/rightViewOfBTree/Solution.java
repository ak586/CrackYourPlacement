package day24.rightViewOfBTree;

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
    static List<Integer> ans;
    // recursive code 
    // visit right end first and add  first visited node of current level in ans
    void helper(TreeNode root, int level){
        if(root==null) return ;
        if(ans.size()==level)
        ans.add(root.val);
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ans=new ArrayList<>();
        helper(root, 0);
        // iterative code
        if(root==null) return ans;
        Queue<TreeNode > q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int currLevelSize=q.size();
            for(int i=0; i<currLevelSize; i++){
                TreeNode curr=q.poll();
                if(i==currLevelSize-1) ans.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
        }
        return ans;
    }
}
