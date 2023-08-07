package day29.zigZagTraversal;



//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class Solution
{
    
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	   ArrayList<Integer> ans=new ArrayList<>();
	   Queue<Node>q=new LinkedList<>();
	   boolean flag=false;
	 
	   if(root==null) return ans;
	   q.add(root);
	   while(q.size()>0){
	       int currLevel=q.size();
	       ArrayList<Integer>temp=new ArrayList<>();
	       for(int i=0; i<currLevel; i++){
	           Node curr=q.poll();
	           temp.add(curr.data);
	           if(curr.left!=null) q.add(curr.left);
	           if(curr.right!=null) q.add(curr.right);
	       }
	       if(flag) Collections.reverse(temp);
	       ans.addAll(temp);
	       flag=!flag;
	   }
	   return ans;
	}
}
