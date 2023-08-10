package day32.createTreeFromPreorderAndPostorder;


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
 * 
 */
// we can't create exact tree from postorder and preorder so there are multiple solutions possible

class Solution {
    public TreeNode construct(int []pre, int[]post, int preStart, int preEnd, int postStart, int postEnd){
        if(preStart>preEnd ||postStart>postEnd) return null;
        if(preStart==preEnd) return new TreeNode(pre[preStart]);
        
        TreeNode root=new TreeNode(pre[preStart]);
        int target=pre[preStart+1];
        int i=postStart;
        while(i<postEnd){
            if(target==post[i]) break;
            i++;
        }


// find target in post array 
        int postEndL=i;
        int postStartL=postStart;
        int postStartR=i+1;
        int postEndR=postEnd-1;

// find the preorder by getting the number of elements in the left and right traversal of postorder
        int preStartL=preStart+1;
        int preEndL=preStart+(postEndL-postStart+1);

        int preStartR=preEndL+1;
        int preEndR=preEnd;

        root.left=construct(pre, post,preStartL,  preEndL, postStart, postEndL);
        root.right=construct(pre, post,preStartR,  preEndR, postStartR, postEndR);
        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, postorder, 0, preorder.length-1,0,postorder.length-1);
    }
}