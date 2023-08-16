package day38.zeroAndOnes;

class Solution {
    static int dp[][][];
    
    public int helper(int i, int m, int n, String strs[]){
        if(i==0) return 0;
        if(dp[i][m][n]!=-1) return dp[i][m][n];
        int zero=0;
        int one=0;
        for(int j=0; j<strs[i-1].length(); j++){
            if(strs[i-1].charAt(j)=='0') zero++;
            else one++;
        }
        int ans=0;
        if(zero<=m && one<=n)
        ans=1+helper(i-1, m-zero, n-one,strs);
        ans=Math.max(ans, helper(i-1, m, n, strs));
        dp[i][m][n]=ans;
        return ans;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new int[strs.length+1][m+1][n+1];
        for(int i=1; i<=strs.length; i++){
            int zero=0;
            int one=0;
            for(int j=0; j<strs[i-1].length(); j++){
                if(strs[i-1].charAt(j)=='0') zero++;
                else one++;
            }

            for(int j=0; j<=m; j++){
                for(int k=0; k<=n; k++){
                    if(zero<=j && one<=k)
                    dp[i][j][k]=Math.max(1+dp[i-1][j-zero][k-one],dp[i-1][j][k]);
                    else dp[i][j][k]=dp[i-1][j][k];
                }
            }
        }

        return dp[strs.length][m][n];

    }
}
