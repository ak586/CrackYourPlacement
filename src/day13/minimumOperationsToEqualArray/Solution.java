package day13.minimumOperationsToEqualArray;

class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        long sum=0;
        for(int a: nums){
            min=Math.min(min,a);
            sum+=a;
        }
        return(int)(sum-min*nums.length);
    }
}
