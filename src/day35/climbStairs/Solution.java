package day35.climbStairs;

class Solution {
    int helper(int n){
        if(n==0 || n==1) return 1;
        return helper(n-1)+ helper(n-2);
    }

    public int climbStairs(int n) {
        int prev1=1;
        int prev2=1;
        int ans=0;
        for(int i=2; i<=n; i++){
            ans=prev1+prev2;
            prev2=prev1;
            prev1=ans;
        }
        return prev1;
    }
}
