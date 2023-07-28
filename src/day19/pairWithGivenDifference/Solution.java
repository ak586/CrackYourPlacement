package day19.pairWithGivenDifference;

import java.util.*;

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        Set<Integer> s=new HashSet<>();
        int i=0;
        while(i<size){
            if(s.contains(n+arr[i])|| s.contains(arr[i]-n)){
                return true;
            }
            s.add(arr[i]);
            i++;
        }
        return false;
        
        
    }
}