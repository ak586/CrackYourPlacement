package day1.ChocolateDistribution;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // sort the array and use sliding window 
        Collections.sort(a);
        int i=0;
        int j=m-1;
        long ans=Integer.MAX_VALUE;
        while(j<n){
            long start=a.get(i);
            long end=a.get(j);
            ans=(long)Math.min(ans, end-start);
            i++;
            j++;
            
        }
        return ans;
    }
}
