package day21.pathSum;

class Solution {
    public boolean hasPathSum(TreeNode root, int target) {
        if(root==null){
           return false;
        }
        target=target-root.val;
        if(root.left==null && root.right==null) return target==0;
        boolean l= hasPathSum(root.left,target );
        boolean r=hasPathSum(root.right, target);
        return l||r;
    }
}
