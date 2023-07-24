package day15.distinctSubsequences;

import java.util.*;

class Solution {
    // public int helper(int ind, String curr, String s, String t){
    //     if(ind>=s.length() ||curr.length()>=t.length()){
    //         if(curr.equals(t)) return 1;
    //         return 0;
    //     }
    //      int ans=0;
    //     if(s.charAt(ind)==t.charAt(curr.length()))
    //     ans+=helper(ind+1, curr+s.charAt(ind),s,t);
    //     ans+=helper(ind+1, curr,s,t);
    //     return ans;

    // }
    
    static int dp[][];


    public int helper(int i, int j, String s, String t){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(s.charAt(i)==t.charAt(j)) ans+=helper(i-1, j-1 , s, t);
        ans+=helper(i-1, j, s,t);
        dp[i][j]=ans;
        return ans;
    }
    public int numDistinct(String s, String t) {
        dp=new int[s.length()][t.length()];
        for(int arr[]: dp ){
            Arrays.fill(arr,-1);
        }

        return helper(s.length()-1, t.length()-1,s, t);
    }
}
