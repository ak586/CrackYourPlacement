package day05.wordSearch;

class Solution
{
    public boolean helper(int i , int j, char [][]board, String word, String curr, boolean [][]visited ){
        if(i<0 || j<0 ||i>=board.length || j>=board[0].length) return word.equals(curr);
        if(word.equals(curr)) return true;
        if(visited[i][j] ||  board[i][j]!=word.charAt(curr.length())) return false;
        
        visited[i][j]=true;
        boolean ans=false;
            boolean a=helper(i+1, j, board, word, curr+board[i][j],visited);
            boolean b=helper(i, j+1, board, word, curr+board[i][j],visited);
            boolean c=helper(i, j-1, board, word, curr+board[i][j],visited);
            boolean d=helper(i-1, j, board, word, curr+board[i][j],visited);
           ans=ans|| a||b||c||d;
    
        visited[i][j]=false;
        return ans;
        
    }
    
    public boolean isWordExist(char[][] board, String word)
    {
        boolean[][] visited=new boolean [board.length][board[0].length];
        int m=board.length;
        int n=board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0))
                    if(helper(i, j, board, word, "", visited)) return true;
            }
        }
       return helper(0, 0,board, word,"",visited);
    }
}
