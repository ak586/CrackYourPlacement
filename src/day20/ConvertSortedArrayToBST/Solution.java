package day20.ConvertSortedArrayToBST;

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


    public TreeNode helper(int nums[], int start,int end){
        if(start>end) return null;
        if(start==end){
            return new TreeNode(nums[start]);
        }
        int mid=(end-start)/2+start;
        // System.out.println(mid+" "+start+" "+end);
        TreeNode root=new TreeNode(nums[mid]);
        // System.out.println(root.val);
        root.left=helper(nums, start, mid-1);
        root.right=helper(nums, mid+1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}
