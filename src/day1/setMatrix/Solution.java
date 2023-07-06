package day1.setMatrix;

class Solution {
    // approach 1 
    // TC: O(m*n) 
    // SC: O(m+n)
    public void helper1(int [][]matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        boolean  col[]=new boolean [n];
        boolean row[]=new boolean  [m];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    col[j]=true;
                    row[i]=true;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(col[j] || row[i]){
                    matrix[i][j]=0;
                }
            }
        }
    }
    // optimised approach 
    // First check  if first row and first column contains any zero or not
    // use the first row and column as map and make changes in it
    public void setZeroes(int[][] matrix) {
        boolean row0Has0=false;
        boolean col0Has0=false;
        
        int i=0;
        int j=0;
        int m=matrix.length;
        int n=matrix[0].length;
        for( j=0; j<n; j++)
        if(matrix[i][j]==0) {
            row0Has0=true;
            break;
        }
        j=0;
        for(i=0; i<m; i++)
        if(matrix[i][j]==0){
            col0Has0=true;
            break;
        }

       for( i=1; i<m; i++){
           for( j=1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
           }

       }
       for( i=1; i<m; i++){
           for( j=1; j<n; j++){
               if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
           }
       }
// handling first column and row 
       if(row0Has0){
           for(i=0; i<n; i++)
           matrix[0][i]=0;
       }
       if(col0Has0){
           for(i=0; i<m; i++)
           matrix[i][0]=0;       
           }
       
}
}


