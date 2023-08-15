package day37.coinChange;

// User function Template for Java
// Based on unbounded knapsack

class Solution {
    // recursive
    public long helper(int n, int sum ,int coins[]){
        if(sum==0) return 1;
        if(n==0) return 0;
        if(sum>=coins[n-1]){
            return helper(n, sum-coins[n-1], coins)+helper(n-1, sum, coins);
        }
        return helper(n-1, sum,coins);
    }
    
    
    
    public long count(int coins[], int N, int sum) {

        // long dp[][]=new long [N+1][sum+1];
        // for(int i=0; i<=N; i++)
        //     dp[i][0]=1;
        
        
            
        // for(int i=1; i<=N; i++){
        //     for(int j=0; j<=sum; j++){
        //         if(j>=coins[i-1]){
        //             dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
        //         }
        //         else dp[i][j]=dp[i-1][j];
        //     }
        // }
        
        long prev[]=new long[sum+1];
        long curr[]=new long[sum+1];
        prev[0]=1;
        curr[0]=1;
        
        for(int i=1; i<=N; i++){
            for(int j=0; j<=sum; j++){
                if(j>=coins[i-1]){
                    curr[j]=curr[j-coins[i-1]]+prev[j];
                }
                else curr[j]=prev[j];
            }
            prev=curr;
        }
        
        
        
        
        return curr[sum];
        
    }
}
