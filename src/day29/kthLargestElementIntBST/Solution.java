package day29.kthLargestElementIntBST;

class Solution
{
    static int k;
    static int ans;
    void fun(Node root){
        if(root==null) return ;
        fun(root.right);
        if(k==1) ans=root.data;
        k--;
        fun(root.left);
    }
    
    public int kthLargest(Node root,int K)
    {
        k=K;
        ans=0;
        fun(root);
        return ans;
    }
}
