package day04.maximumPointsFromCards;
// sliding window
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        long totalSum=0;
        int N=cardPoints.length;
        int i=0;
        int j=0;
        int ans=0;
        for(int a: cardPoints) totalSum+=a;
        // create a window of n-k(these elements will not be selected)
        long removeSum=0;
        if(N==k) return (int)totalSum;
        while(j<N){
            removeSum+=cardPoints[j];
            if(j-i+1==N-k){
                ans=(int)Math.max(totalSum-removeSum, ans);
                removeSum-=cardPoints[i];
                i++;
            }
            j++;
        }
        return ans;
    }
}
