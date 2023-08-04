package day26.ratInAMaze;

class Solution {
    public static void helper(int i, int j, String currPath, int m[][] , int n, ArrayList<String> ans
    , boolean [][]visited){
        if(i==n-1 && j==n-1){
            if(m[i][j]==1){
            ans.add(currPath);
            }
            return ;
        }
        if(i>=n || j>=n || visited[i][j]==true||m[i][j]==0) return ;
        visited[i][j]=true;
        if(i<n-1) helper(i+1, j, currPath+'D', m, n, ans,visited);
        if(j>0) helper(i, j-1, currPath+'L',m, n, ans,visited);
        if(j<n-1) helper(i, j+1, currPath+'R',m, n ,ans,visited);
        if(i>0) helper(i-1, j, currPath+'U',m,n,ans,visited);
        visited[i][j]=false;
    } 
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean [][]visited=new boolean[n][n];
        ArrayList<String> ans=new ArrayList<>();
        helper(0,0,"", m, n, ans,visited);
        return ans;
        
    }
}
