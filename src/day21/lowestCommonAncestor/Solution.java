package day21.lowestCommonAncestor;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p||root==q) return root;
        TreeNode lft=  lowestCommonAncestor(root.left, p, q);
        TreeNode rgt = lowestCommonAncestor(root.right, p, q);
        // both are found int in left and right subtrees then ans is current node
        if (lft != null && rgt != null)
            return root;
        if(lft==null) return rgt;
        else return lft;
    }
}
