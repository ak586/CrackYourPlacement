package day03.containerWithMostWater;

// brute force: O(n^2)

class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int ht=Math.min(height[i], height[j]);
            int width=j-i;
            ans = Math.max(ans, Math.max(ht * width, ans));
            // ignore the minimum height
            if(height[i]>height[j]) j--;
            else i++;
        }
        return ans;
    }
}
