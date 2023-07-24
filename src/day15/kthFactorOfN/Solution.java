package day15.kthFactorOfN;
import java.util.*;
class Solution {
// O(sqrt(n)) with extra space
    public int helper(int n, int k){
        ArrayList<Integer> firstHalf=new ArrayList<>();
        ArrayList<Integer> secondHalf=new ArrayList<>();
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0){
                firstHalf.add(i);
                if(n/i!=i) secondHalf.add(n/i);
            }
        }
        Collections.reverse(secondHalf);
        if(k> firstHalf.size()+secondHalf.size()) return -1;
        if(k<=firstHalf.size()) return firstHalf.get(k-1);
        else return secondHalf.get(k-firstHalf.size()-1);
    }


    // using constant space
    // factors exist in pair for example for 12-> (1,12), (2,6), (3,4) i.e (i, n/i)
    // in first loop we are considering i 
    // in second loop we are considering n/i
    public int kthFactor(int n, int k) {
        for(int i=1; i<Math.sqrt(n); i++){
            if(n%i==0)
            k--;
            if(k==0) return i;
        }

        for(int i=(int)Math.sqrt(n); i>=1; i--){
            if(n%(n/i)==0) k--;
            if(k==0) return  n/i;
        }
        return -1;
    }

}
