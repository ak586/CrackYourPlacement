package day03.foursum;

import java.util.*;

class Solution {
    // Brute force O(n^4)

    // Optimised: TC:O(n^3)
    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(arr);
        int N=arr.length;
        // avoid integer overflow/underflow
        long m,n ,o,p;

        // select two numbers then for last two use  two pointer approach same as 2sum
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                 m=arr[i];
                 n=arr[j];
                long t=target-m-n;
                int left=j+1;
                int right=N-1;
                while(left<right){
                    o=arr[left];
                    p=arr[right];
                    // int  sum=arr[left]+arr[right];
                    long sum=o+p;
                    if(sum==t){
                        int a[]={arr[i], arr[j],arr[left], arr[right]};
                        List<Integer> temp = new ArrayList<Integer>();
                        for(int x: a) temp.add(x);
                        ans.add(temp);
                        while(left<right && arr[left]==a[2]) left++;
                        while(left<right && arr[right]==a[3]) right--;
                    }
                    else if(sum>t) right--;
                    else left++;
                }
            
            while(j+1 <N  && arr[j]==arr[j+1]) j++;
            }
            while(i+1<N && arr[i]==arr[i+1]) i++;
        }
        return ans;
    }
}
