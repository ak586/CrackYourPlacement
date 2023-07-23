package day14.missingNumber;

class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        for( int a: nums )
            sum+=a;
        int desiredSum=(n)*(n+1)/2;
        
        return desiredSum-sum;
    }
}
