package day12.diameterOfBinaryTree;

class Solution {
    
    static int dia;
    public int height(TreeNode root){
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        dia=Math.max(lh+rh, dia);
        return 1+Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dia=0;
        height(root);
        return dia;
    }
}
