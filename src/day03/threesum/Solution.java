package day03.threesum;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        // select first element using for loop and  then use two pointer  for next two elements
        for(int start=0; start<n; start++){
           int target=-arr[start];
           int i=start+1;
           int j=n-1;
           while (i < j) {
               int sum = arr[i] + arr[j];
               if (sum < target)
                   i++;
               else if (sum > target)
                   j--;
               else {
                   List<Integer> temp = new ArrayList<>();
                   temp.add(arr[start]);
                   temp.add(arr[i]);
                   temp.add(arr[j]);
                   ans.add(temp);
                   int a = arr[i];
                   int b = arr[j];
                   //    ignore duplicates 
                   while (i < j && arr[i] == a)
                       i++;
                   //    ignore duplicates 
                   while (i < j && arr[j] == b)
                       j--;
               }

           }
        //    ignore duplicates of arr[start]
           while(start+1<n && arr[start]==arr[start+1]) start++;
       }
    return ans;
    }
}
