package day04.jumpGame;

// use greedy approach start from the  backward  and the target index
class Solution {
    static int canReach(int[] A, int N) {
       int targetIndex=N-1;
       int i=N-1;
       while(i>=0){
           if(i+A[i]>=targetIndex)
           targetIndex=i;
           i--;
       }
       return targetIndex==0?1:0;
       
    }
};
