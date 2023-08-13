package day35.perfectSumProblem;

class Solution{

static int m=(int)1e9+7;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int dp[][]=new int [n+1][sum+1];
	    for(int i=0; i<=n; i++){
	        for(int j=0; j<=sum; j++){
	            if(i==0) dp[i][j]=0;
	            if(j==0) dp[i][j]=1;
	        }
	    }

	    
	    for(int i=1; i<=n; i++){
	        for(int j=0; j<=sum; j++){
	            if(j>=arr[i-1]){
	                dp[i][j]=(dp[i-1][j-arr[i-1]]%m+dp[i-1][j]%m)%m;
	            }
	            else dp[i][j]=dp[i-1][j];
	        }
	    }
	    
	    return dp[n][sum];
	} 
}
