package day26.bfsOfGraph;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       
       boolean visited[]=new boolean[V];
       ArrayList<Integer>bfs=new ArrayList<>();
       Queue<Integer>q=new LinkedList<>();
       visited[0]=true;
       q.add(0);
       while(q.size()>0){
           
           int top=q.poll();
           bfs.add(top);
           
           for(int a: adj.get(top)){
               if(visited[a]==false){
                   visited[a]=true;
                   q.offer(a);
               }
           }
       }
       
       return bfs ;
    }
}
