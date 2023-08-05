package day27.diagonalTraversalOfBT;
class Solution
{
     public ArrayList<Integer> diagonal(Node root)
      {
           ArrayList<Integer>ans=new ArrayList<>();
           if(root==null) return ans;
           Queue<Node>q=new LinkedList<>();
           q.add(root);
           while(q.size()>0){
               int count=q.size();
               while(count>0){
                   Node curr=q.poll();
                   count--;
                   while(curr!=null){
                       if(curr.left!=null) q.add(curr.left);
                       ans.add(curr.data);
                       curr=curr.right;
                   }
               }
           }
           return ans;
               
      }
}

