package day33.medianOfBst;

class Solution
{
    static Node findRightMost(Node leftNode, Node curr){
        while(leftNode.right!=null && leftNode.right!=curr){
            leftNode =leftNode.right;
        }
        return leftNode;
    }
    static int countNodes(Node curr){
        int count=0;
        while(curr!=null){
            Node leftNode =curr.left;
            if(leftNode ==null){
                count++;
                curr=curr.right;
            }
            else{
                Node rightMost=findRightMost(leftNode, curr);
                if(rightMost.right==null){
                    rightMost.right=curr;
                    curr=curr.left;
                }
                else{
                    rightMost.right=null;
                    count++;
                    curr=curr.right;
                }
            }
        }
        return count;
    }
    

    
    
    
    public static float findMedian(Node root)
    {
      int n=countNodes(root);
      int i=0;
      int j=0;
      float median=0;
      Node curr=root;
      int count=0;
      while(curr!=null){
            Node leftNode =curr.left;
            if(leftNode ==null){
                count++;
                if(n%2==0){
                    if(count==n/2) median=curr.data;
                    if(count==n/2+1) {
                        median+=curr.data;
                        median=median/2;
                        break;
                    }
                }
                else {
                    if(count==(n+1)/2) return curr.data;
                }
                curr=curr.right;
            }
            else{
                Node rightMost=findRightMost(leftNode, curr);
                if(rightMost.right==null){
                    rightMost.right=curr;
                    curr=curr.left;
                }
                else{
                    rightMost.right=null;
                    count++;
                    
                    if(n%2==0){
                    if(count==n/2) median=curr.data;
                    if(count==n/2+1) {
                        median+=curr.data;
                        median=median/2;
                        break;
                    }
                }
                else {
                    if(count==(n+1)/2) {
                        median=curr.data;
                        break;
                    }
                }
                    
                    curr=curr.right;
                }
            }
        }
        return median;
      
        
    }
}
