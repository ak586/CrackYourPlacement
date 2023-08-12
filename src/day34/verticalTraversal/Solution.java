package day34.verticalTraversal;

class Pair{
    int hd;
    Node curr;
    Pair(int hd, Node curr){
        this.hd=hd;
        this.curr=curr;
    }
}

class Solution
{
    
    static ArrayList <Integer> verticalOrder(Node root)
    {
        TreeMap<Integer, ArrayList<Integer>>map=new TreeMap<>();
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null) return ans;
        
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,root));
        while(q.size()>0){
            Pair p=q.remove();
            int hd=p.hd;
            Node curr=p.curr;
            if(map.containsKey(hd)){
                ArrayList<Integer>arr=map.get(hd);
                arr.add(curr.data);
                map.put(hd, arr);
            }
            else{
                ArrayList<Integer>arr=new ArrayList<>();
                arr.add(curr.data);
                map.put(hd,arr);
            }
            if(curr.left!=null) q.add (new Pair(hd-1, curr.left));
            if(curr.right!=null)q.add(new Pair(hd+1, curr.right));
        }
        
        for(int a: map.keySet()){
            ans.addAll(map.get(a));
        }
        return ans;
    }
}