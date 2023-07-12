package day07.gameoflife;

import java.util.*;

class Pair{
    int zero;
    int one;
    Pair(int zero , int one){
        this.zero=zero;
        this.one=one;
    }
}

class Solution {

    public Pair countNeighbors(int [][]arr, int i, int j){
        System.out.println(i+" "+j);
        int m=arr.length;
        int n=arr[0].length;
        int one=0;
        int zero=0;
        
        // up
        if(i-1>=0){
            if(Math.abs(arr[i-1][j])==1) one++;
            else zero++;
        }
        // down
        if(i+1<m){
            if(Math.abs(arr[i+1][j])==1) one++;
            else zero++;
        }

// left
        if(j-1>=0){
            if(Math.abs(arr[i][j-1])==1) one++;
            else zero++;
        }
// right
        if(j+1<n){
            if(Math.abs(arr[i][j+1])==1) one++;
            else zero++;
        }
// \this diagonal lower part
        if(i+1<m && j+1<n){
            if(Math.abs(arr[i+1][j+1])==1) one++;
            else zero++;
        }
// \this diagonal upper part
        if(i-1>=0 && j-1>=0){
            if(Math.abs(arr[i-1][j-1])==1) one++;
            else zero++;
        }
//  / this dignoal upper part
    if(j+1<n && i-1>=0){
        if(Math.abs(arr[i-1][j+1])==1) one++;
            else zero++;
    }
//  /this diagongal lower part
    if(i+1<m && j-1>=0){
        if(Math.abs(arr[i+1][j-1])==1) one++;
            else zero++;
    }
    Pair ans=new Pair(zero, one);
    return ans;


    }



    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int curr=board[i][j];
                Pair count= countNeighbors(board, i,j);
                if(curr==1){
                    if(count.one>3 || count.one<2) curr=-1;
                }
                else{
                    if(count.one==3) curr=2;
                }
                board[i][j]=curr;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==-1) board[i][j]=0;
                if(board[i][j]==2) board[i][j]=1;
            }
        }
    }
}
