package day03.bestTimetoBuyandSell2;

class Solution {
  
  // TC: O(n) 
  // SC: O(2*n)
  public int helper(int prices[], int buy, int ind, int dp[][]){
    if(ind ==prices.length)
    return 0;
  if(dp[ind][buy]!=-1) return dp[ind][buy];
    if(buy==1){
      // buy current stock or don't buy current stock
      int take=helper(prices, 0,ind+1,dp)-prices[ind];
      int notTake=helper(prices, 1, ind+1,dp);
      dp[ind][buy]=Math.max(take, notTake);
      return Math.max(take, notTake);
    }
    else{
      int sell =helper(prices, 1, ind+1,dp)+prices[ind];
      int notSell=helper(prices, 0, ind+1,dp);
      dp[ind][buy]=Math.max(sell , notSell);
      return Math.max(sell , notSell);
    }
  }



// got this one from linkedin sell as soon as the price increases without using dp
public int helper2(int []prices, int n){
    int profit=0;
    for(int i=1; i<n; i++)
    if(prices[i-1]<prices[i]) profit+=prices[i]-prices[i-1];
    return profit;
}



// using dp 
    public int maxProfit(int[] prices) {
        int n=prices.length;
      
        // recursion 0 to n  iteration n-1 to 0
        // buy->0 to 1
        int prev1=0;
        int prev0=0;
        for(int ind=n-1 ; ind>=0; ind--){
          for(int buy=0; buy<=1; buy++){
              if(buy==1){
              int take=prev0-prices[ind];
              int notTake=prev1;
              prev1=Math.max(take, notTake);
          }
           else{
               int sell =prev1+prices[ind];
               int notSell=prev0;
               prev0=Math.max(sell , notSell);
              }
      }
      
 }
        return prev1;

    }
}