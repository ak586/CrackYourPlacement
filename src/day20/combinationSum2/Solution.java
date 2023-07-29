package day20.combinationSum2;

import java.util.*;

class Solution {
    static List<List<Integer>> ans;
     static void  helper(int ind, int arr[], int s, List<Integer> ls){
        if(s==0) {
            ans.add(new ArrayList<>(ls));
            return ;
        }
        for(int i=ind ; i<arr.length; i++){
            // skip duplicates
            if(i!=ind && arr[i]==arr[i-1]) continue;
            if(s<arr[i]) break ;
            ls.add(arr[i]);
            helper(i+1, arr, s-arr[i], ls);
            ls.remove(ls.size()-1);
        }
    }
    
    
    public static List<List<Integer>> combinationSum2(int[] a, int s) {
       Arrays.sort(a);
       ans=new ArrayList<>();
       helper(0, a, s,new ArrayList<>());
       return ans;
    }
}
