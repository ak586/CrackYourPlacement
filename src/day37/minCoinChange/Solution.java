package day37.minCoinChange;


class Solution{
    static List<Integer> minPartition(int n)
    {
        List<Integer> ans=new ArrayList<>();
        // greedy
        int arr[]={2000,500, 200, 100, 50, 20, 10, 5, 2, 1};
        int i=0;
        while(n!=0){
            if(n>=arr[i]){
                ans.add(arr[i]);
                n=n-arr[i];
            }
            else
                i++;
        }
        return ans;
        
    }
}