package day25.nodesAtKDistance;

class Solution {
    static List<Integer> ans;
    // printing node at k distance
    void helper1(TreeNode temp, int k){
        if(temp==null|| k<0) return ;
        if(k==0){
            ans.add(temp.val);
        }
        helper1(temp.left, k-1);
        helper1(temp.right, k-1);  
    }


    int  helper(TreeNode root, TreeNode target, int k){
        if(root==null) return -1;
        if(root==target) return 0;
        int inLeft=helper(root.left, target, k);
        int inRight=helper(root.right, target, k);
        if(inLeft!=-1){
            // if root is at k distance then print k
            if(1+inLeft==k) ans.add(root.val);
            // here we are 1 to reach root and again 1 is to reach root.right that's  why -2
            helper1(root.right, k-inLeft-2);
            return 1+inLeft;
        }
        // same for ifFound in rightSubtree
        if(inRight!=-1){
            if(1+inRight==k) ans.add(root.val);
            helper1(root.left, k-inRight-2);
            return 1+inRight;
        } 
        return -1;
    
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans=new ArrayList<>();
        helper1(target, k);
        helper(root, target, k);
        return ans;
    }
}
// one more way will be  to keep track of parents
// one more approach is to get root to node path
