package day36.targetSum;

class Solution {
    static int m = (int) 1e9 + 7;

    static int findTargetSumWays(int[] arr, int n, int target) {
        int sum = 0;
        for (int a : arr)
            sum += a;

        // divide in two subsets s1 and s2
        // s1-s2=target
        // hrer we are s1+(-s2) s2 contains all numbers whose sign will be reversed

        int s1 = (sum + target) / 2;
        if ((sum + target) % 2 != 0)
            return 0;

        int dp[][] = new int[n + 1][s1 + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= s1; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s1; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] % m + dp[i - 1][j] % m;
                    dp[i][j] %= m;
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][s1];

    }
};