package day34.partitionEqualSum;

class Solution{
    
    // recursive
    static int targetSum(int n, int arr[], int target){
        if(target==0)
        return 1;
        if(n==0) return 0;
        if(target>=arr[n-1]){
            return targetSum(n-1, arr, target-arr[n-1])| targetSum(n-1, arr, target);
        }
        else return  targetSum(n-1, arr, target);
        
    }
    
    static int equalPartition(int N, int arr[])
    {
        int totalSum=0;
        for(int a: arr)
            totalSum+=a;
        if(totalSum%2!=0) return 0;
        // now if we get an subset with totalSum/2 then remaining parts will also be totalSum/2
       int dp[][]=new int [N+1][totalSum/2+1];
       
       for(int i=0; i<=N; i++){
           for(int j=0; j<=totalSum/2; j++){
               if(i==0) dp[i][j]=0;
               if(j==0) dp[i][j]=1;
           }
       }
       for(int i=1; i<=N; i++){
           for(int j=1; j<=totalSum/2; j++){
               if(j>=arr[i-1]){
                   dp[i][j]=dp[i-1][j-arr[i-1]]| dp[i-1][j];
               }
               else dp[i][j]=dp[i-1][j];
           }
       }
       
       
        return dp[N][totalSum/2];
        
    }
}
