package day30.pathSum3;

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
    // use hashmap and search it for currsum-targetSum
    static int count;
    // use long to avoid overflow in last case
    HashMap<Long, Integer> map;
    void helper(TreeNode root, long currSum, int targetSum){
        if(root==null){
            return ;
        }
        currSum+=root.val;
        if(map.containsKey(currSum-targetSum)) {
            count+=map.get(currSum-targetSum);
        }
        if(currSum==targetSum) ++count;
        map.put(currSum ,map.getOrDefault(currSum ,0)+1);
        helper(root.left, currSum, targetSum);
        helper(root.right, currSum, targetSum);
        map.put(currSum , map.get(currSum)-1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        count=0;
        map=new HashMap<>();
        helper(root, 0, targetSum);
        return count;
    }
}
