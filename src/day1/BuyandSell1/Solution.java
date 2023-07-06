package day1.BuyandSell1;

class Solution {
    
// O(n) and O(n)
// Method 1  keep the record of maximum price(selling price) in future and buy it everyday 
//     public int maxProfit(int[] prices) {
//         int maxProfit=0;
//         int n=prices.length;
//         int rightMax[]=new int[prices.length];
//         int currMax=Integer.MIN_VALUE;

//     for(int i=n-1; i>=0; i--){
//         if(prices[i]>currMax){
//             currMax=prices[i];
//     }
//         rightMax[i]=currMax;
// }

// for(int i=0; i<n; i++){
//    maxProfit=Math.max(maxProfit, rightMax[i]-prices[i]);
// }
    //    return maxProfit; 
    // }

// Optimised approach O(n) and O(1)
// keep the record of pervious minimum price and sell it everyday
    public int maxProfit(int[] arr) {
        int maxProfit=0;
        int n=arr.length;
        int minPrice=arr[0];
        for(int i=0; i<n;  i++){
            minPrice=Math.min(minPrice, arr[i]);
            maxProfit=Math.max(maxProfit, arr[i]-minPrice);
        }
        return maxProfit;
    }

}
