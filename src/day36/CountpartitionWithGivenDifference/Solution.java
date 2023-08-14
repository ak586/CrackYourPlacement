package day36.partitionWithGivenDifference;

class Solution{
    static int m=(int)1e9+7;
    public int countPartitions(int n, int d, int arr[]){
        int sum=0;
        for(int a: arr) sum+=a;
        
        // s1-s2=d;
        // s1+s2=sum;
       int  s1=(sum+d)/2;
       if((sum+d)%2!=0)return 0;
        
        
        int dp[][]=new int [n+1][s1+1];

	    for(int i=0; i<=n; i++){
	        for(int j=0; j<=s1; j++){
	            if(i==0) dp[i][j]=0;
	            if(j==0) dp[i][j]=1;
	        }
	    }
	    
	    for(int i=1; i<=n; i++){
	        for(int j=0; j<=s1; j++){
	            if(j>=arr[i-1]){
	                dp[i][j]=dp[i-1][j-arr[i-1]]%m+dp[i-1][j]%m;
	                dp[i][j]%=m;
	            }
	            else dp[i][j]=dp[i-1][j];
	        }
	    }
	    return dp[n][s1];
	    

        
    }
}
