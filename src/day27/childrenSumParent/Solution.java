package day27.childrenSumParent;

class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static boolean helper(Node root){
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        boolean l=helper(root.left);
        boolean r=helper(root.right);
        int sum=0;
        if(root.left!=null) sum+=root.left.data;
        if(root.right!=null) sum+=root.right.data;
        
        return (sum==root.data) && l && r;
    }
    
    public static int isSumProperty(Node root)
    {
       if( helper(root)) return 1;
       return 0;
        
    }
}
