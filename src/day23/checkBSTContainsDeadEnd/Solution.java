package day23.checkBSTContainsDeadEnd;

class Solution
{
   public static boolean isDeadEnd(Node root) {
    return helper(root, 1, Integer.MAX_VALUE);
    }

// think about the permissible range 
public static boolean helper(Node root, int min, int max) {
    if(root==null) return false;
    if( min>=max) return true;
    boolean lft=helper(root.left, min, root.data-1);
    boolean rgt=helper(root.right, root.data+1, max);
    return lft||rgt;
}

}
