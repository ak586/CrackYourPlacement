package day37.rodCutting;

class Solution {

    // recursive
    public int helper(int rodSize, int cutLength, int[] price) {
        if (rodSize == 0)
            return 0;
        if (cutLength == 0)
            return 0;
        if (rodSize >= cutLength) {
            return Math.max(price[cutLength - 1] + helper(rodSize - cutLength, cutLength, price),
                    helper(rodSize, cutLength - 1, price));
        }

        return helper(rodSize, cutLength - 1, price);
    }

    public int cutRod(int price[], int n) {
        int rodSize = n;
        int cutLength = n;

        // tabulisation in O(n^2) space
        // int dp[][]=new int[n+1][n+1];

        // for(int i=1; i<=cutLength; i++){
        // for(int j=1; j<=rodSize; j++){
        // if(j>=i){
        // dp[i][j]=Math.max(price[i-1]+dp[i][j-i], dp[i-1][j]);
        // }
        // else dp[i][j]=dp[i-1][j];
        // }
        // }
        // return dp[n][n];

        // optimised

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= cutLength; i++) {
            for (int j = 1; j <= rodSize; j++) {
                if (j >= i) {
                    curr[j] = Math.max(price[i - 1] + curr[j - i], prev[j]);
                } else
                    curr[j] = prev[j];
            }
            prev = curr;
        }
        return curr[n];

    }
}
