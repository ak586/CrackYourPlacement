package day38.countBits;

class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        for(int i=1; i<=n; i++){
            // i & i-1 resets the rightMost set bit 
            ans[i]=ans[i&(i-1)]+1;
        }
        
    return ans;
    }
}
