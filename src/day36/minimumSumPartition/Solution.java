package day36.minimumSumPartition;

import java.util.*;

class Solution
{
    
	public int minDifference(int arr[], int n) 
	{ 
	    int sum=0;
	    for(int a: arr)
	        sum+=a;
	    boolean dp[][]=new boolean [n+1][sum+1];
	    for(int i=0; i<=n; i++){
	        for(int j=0; j<=sum; j++){
	            if(i==0)dp[i][j]=false;
	            if(j==0) dp[i][j]=true;
	        }
	    }
	    
	   //last row will give all the possible sums
	    for(int i=1; i<=n; i++){
	        for(int j=0; j<=sum; j++){
	            if(j>=arr[i-1]){
	                dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            }
	            else dp[i][j]=dp[i-1][j];
	        }
	    }
	    
	    ArrayList<Integer> possibleSum=new ArrayList<>();
	    for(int j=0; j<=sum; j++){
	        if(dp[n][j]) possibleSum.add(j);
	    }
	    
	    
	    int ans=Integer.MAX_VALUE;
	    
	    for(int i=0; i<possibleSum.size(); i++ ){
	        ans=Math.min(ans, Math.abs(sum-2*possibleSum.get(i)));
	    }
	    return ans;
	    
	    
	} 
}