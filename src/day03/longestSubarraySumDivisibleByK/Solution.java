package day03.longestSubarraySumDivisibleByK;

import java.util.*;
class Solution {
    
    // Brute force create O(n^3)
    // Approach one: prefix sum O(n^2)


public int helper(int arr[], int n,int k){
    int ans=0;
    int prefixSum=0;
    for(int i=0; i<n; i++){
        prefixSum+=arr[i];
        arr[i]=prefixSum;
    }
    // System.out.println(Arrays.toString(arr));
    for(int i=0; i<n; i++){
        for(int j=i; j<n ; j++){
            int currSum=arr[j];
            if(i!=0) currSum=arr[j]-arr[i-1];
                if(currSum%k==0) ans++;
        }
    }
    return ans;
}
    


/* Optimised approach O(n) using modulo operator
 if s1%k=a and s2%k=a then s2-s1 is divisible by k because
  s1=k*x+a 
  s2=K*y+a
  s2-s1=k(y-x) 
  */
/* special case when remainder is negative
   for ex 7n-3 can be written as 7n+4 here k is 7.
   kx-r == kx+(k-r); 
*/

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int sum=0;
        // subarray of size 0 is always divisible by k
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int rem=sum%k;
            if(rem<0) rem=k+rem;
            if(map.containsKey(rem)){
                map.put(rem, map.get(rem)+1);
                continue;
            }
            map.put(rem, 1);
        }
        int ans=0;

        for(int a: map.keySet()){
            int x=map.get(a);
            if(x>1)
            ans+= ((x)*(x-1))/2;  //choose any two remainders nC2
        }
        return ans;
    }
}
