package day28.uniqueBst2;

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

    public List<TreeNode> helper(int start, int end){
        List<TreeNode>ans=new ArrayList<>();
        if(start>end){
            ans.add(null);
            return ans;
        }
        if(start==end){
            ans.add(new TreeNode(start));
            return ans;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> lBst=helper(start,i-1);
            List<TreeNode> rBst=helper(i+1,end);
            for(int j=0; j<lBst.size(); j++){
                for(int k=0; k<rBst.size(); k++){
                    TreeNode root=new TreeNode(i);
                    root.left=lBst.get(j);
                    root.right=rBst.get(k);
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    static HashMap< Pair<Integer, Integer>, List<TreeNode>>map;

    public List<TreeNode> helperMemo(int start, int end){
        List<TreeNode>ans=new ArrayList<>();
        if(start>end){
            ans.add(null);
            return ans;
        }
        if(map.containsKey(new Pair<>(start, end))) return map.get(new Pair<>(start, end));
        if(start==end){
            ans.add(new TreeNode(start));
            return ans;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> lBst=helperMemo(start,i-1);
            List<TreeNode> rBst=helperMemo(i+1,end);
            for(int j=0; j<lBst.size(); j++){
                for(int k=0; k<rBst.size(); k++){
                    TreeNode root=new TreeNode(i);
                    root.left=lBst.get(j);
                    root.right=rBst.get(k);
                    ans.add(root);
                }
            }
        }
        map.put(new Pair<>(start, end), ans);
        return ans;
    }


    public List<TreeNode> generateTrees(int n) {
        map=new HashMap<>();
        return helperMemo(1, n);
        
    }
}
