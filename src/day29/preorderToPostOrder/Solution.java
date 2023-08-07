package day29.preorderToPostOrder;


class Solution {
    public static Node helper(int pre[], int i, int j){
    if(i>j){
        return null;
    }
    if(i==j){
        return new Node(pre[i]);
    }
    int k=i+1;
    while(k<pre.length && pre[k]<pre[i] )k++;
    Node root=new Node(pre[i]);
    Node left=helper(pre, i+1,k-1);
    Node right=helper(pre, k, j);
    root.left=left;
    root.right=right;
    return root;
}
public static Node post_order(int pre[], int size) 
{
   return helper(pre, 0, pre.length-1);
} 
}
