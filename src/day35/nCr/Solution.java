package day35.nCr;

class Solution{
    static int m=(int)1e9+7;
    static int helper(int n, int r){
        if(r>n) {
            return 0;
        }
        
        if(r==0) return 1;
        if(r==1) return n;
        return helper(n-1,r)+helper(n-1, r-1);
    }
    
    static int nCr(int n, int r)
    {
        int dp[][]=new int[n+1][r+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=r; j++){
                if(j==0) dp[i][j]=1;
                if(j==1) dp[i][j]=i;
            }
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=r; j++){
                dp[i][j]=(dp[i-1][j] %m+dp[i-1][j-1]%m)%m;
            }
        }
        return dp[n][r];
        

    }
}
