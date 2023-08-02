package day24.levelOrder;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            int eleCount=q.size();
            List<Integer> currLevel=new ArrayList<>();
            for(int i=0; i<eleCount; i++){
                TreeNode curr=q.poll();
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
                currLevel.add(curr.val);
            }
            ans.add(currLevel);
        }
        return ans;
    }
}
