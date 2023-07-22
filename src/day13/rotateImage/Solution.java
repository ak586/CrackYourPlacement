package day13.rotateImage;

class Solution {
    public void rotate(int[][] matrix) {
        
        // step 1 take transpose of the matrix
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<i; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // step 2 reverse each row;
        for(int i=0; i<matrix.length; i++){
            int start=0;
            int end=matrix[i].length-1; 
            while(start<end){
                int temp=matrix[i][start];
                matrix[i][start]=matrix[i][end];
                matrix[i][end]=temp;
                start++;
                end--;
            }
        }
        
    }
}
