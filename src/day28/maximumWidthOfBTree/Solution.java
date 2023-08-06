package day28.maximumWidthOfBTree;

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

  
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair <TreeNode, Integer>>q=new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int min=0;
        int ans=0;
        while(q.size()>0){
            int start=0;
            int end=0;
            int count=q.size();
            for(int i=0; i<count; i++){
                Pair<TreeNode, Integer> temp=q.poll();
                TreeNode curr=temp.getKey();
                int j=temp.getValue();
                if(i==0){
                    start=j;
                    min=j;
                }

                if(i==count-1){
                    end=j;
                    ans=Math.max(ans, j-start+1);
                }
                if(curr.left!=null){
                    // to avoid overflow of 2*l we are  marking l as l-minimum index available at that level
                    int l=j-min;
                    q.add(new Pair<>(curr.left,2*l+1));
                }
                if(curr.right!=null){
                    int r=j-min;
                    q.add(new Pair<>(curr.right, 2*r+2));
                }   
            }
        }
        return ans;
     
    }
}
