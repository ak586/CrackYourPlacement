package day26.dfsOfGraph;

class Solution {
    
    public void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer>ans ){
        visited[node]=true;
        ans.add(node);
        for(int a: adj.get(node)){
            if(!visited[a])
            dfs(a, visited, adj, ans);
        }
        
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans=new ArrayList<>();
        boolean visited[]=new boolean [V];
        dfs(0, visited, adj, ans);
        return ans;
    }
}
