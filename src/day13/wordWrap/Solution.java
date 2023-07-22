package day13.wordWrap;

import java.util.*;

class Solution
{
    static int dp[][];
    public int  helper(int i, int curr, int n,int k,int []nums ){
        if(i==n) return 0;
        if(dp[i][curr]!=-1) return dp[i][curr];
        int ans2=Integer.MAX_VALUE;
        int ans1=ans2;
        // if we are in new line then add the current word 
        if(curr==0){
            ans1=helper(i+1, curr+nums[i], n,k,nums);
        }
        // when current line already contains some words two options: if possible insert new word in 
        // current line option 2 : call for insertion in next line
        if(curr!=0){ 
             if(curr+nums[i]+1<=k) ans1=helper(i+1,curr+nums[i]+1, n,k,nums);
             ans2= (int)Math.pow(k-curr,2)+helper(i,0,n,k,nums);
        }
        dp[i][curr]=Math.min(ans1, ans2);
        return Math.min(ans1, ans2);
    }
     
     
    public int solveWordWrap (int[] nums, int k)
    {
        int n=nums.length;
        dp=new int[n+1][k+1];
        for(int arr[]: dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, 0, n, k, nums);
    }
}
