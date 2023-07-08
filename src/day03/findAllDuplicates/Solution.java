package day03.findAllDuplicates;
import java.util.*;
// brute force store the frequency  of all elements in a map 

// Optimised solution Time O(n) and constant extra spaces O(1)
class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        int i=0;
        int n=arr.length;
        while(i<n){
            if(i+1==arr[i] || arr[arr[i]-1]==arr[i] ) i++;
            else{
                int temp=arr[i];
                int j=arr[i]-1;
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        
        List<Integer> ans=new ArrayList<>();

        for( i=0; i<n; i++){
            if(arr[i]!=i+1) ans.add(arr[i]);
        }
        return ans;
    }
}
