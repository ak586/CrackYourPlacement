package day32.morrisInorder;

class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    Node findRightMost(Node leftNode, Node curr){
        while(leftNode.right!=null && leftNode.right!=curr)
            leftNode=leftNode.right;
        return leftNode;
    }
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        Node curr=root;
        while(curr!=null){
            Node leftNode=curr.left;
            if(leftNode==null){
                ans.add(curr.data);
                curr=curr.right;
            }
            else{
                Node rightMost=findRightMost(leftNode, curr);
                // create thread and move to left
                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                }
                // destroy thread
                else{
                    rightMost.right=null;
                    ans.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}
