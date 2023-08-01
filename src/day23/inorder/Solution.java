package day23.inorder;

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
    // recursive solution
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        // iterative solution
        ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode>st=new Stack<>();
        st.push(root);
        while(st.size()>0){
            if(root!=null)
            root=root.left;
            if(root==null){
                TreeNode temp=st.pop();
                ans.add(temp.val);
                root=temp.right;
        }
        if(root!=null)
            st.add(root);
        }
        return ans;
    }
}
