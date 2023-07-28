package day19.productOfArrayExceptItself;

import java.util.*;


class Solution 
{ 
	public static long[] productExceptSelf(int arr[], int n) 
	{ 
       long []ans=new long[n];
       Arrays.fill(ans,1);
       long prod=1;
       long prod2=1;
       for(int i=0; i<n; i++){
           ans[i]*=prod;
           ans[n-i-1]*=prod2;
           prod=arr[i]*prod;
           prod2=arr[n-i-1]*prod2;
       }
       return ans;
	} 
} 
