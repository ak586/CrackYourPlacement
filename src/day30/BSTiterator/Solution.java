package day30.BSTiterator;

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
class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root!=null){
            st.push(root);
            root=root.left;
            if(root==null) break;
        }
    }
    

    public int next() {
        TreeNode temp=st.pop();
        TreeNode root=temp.right;
        while (root != null) {
            st.push(root);
            root = root.left;
            if (root == null)
                break;
        }
        int ans=temp.val;
        return ans;
    }
    
    public boolean hasNext() {
        return st.size()>0;
    }
}
