package day28.uniqueBst1;


   class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: One empty tree is considered a valid BST.
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += dp[j] * dp[i - j - 1];
            }
            dp[i] = count;
        }
        
        return dp[n];
    }
}



