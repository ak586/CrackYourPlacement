package day05.majorityElement;

class Solution {
    // we don't need to check if the ans is the majority element or not because question says there always exist  a mojority elment
// otherwise we have to iterate once more to check if the frequency of ans>n/2 or not
    public int majorityElement(int[] arr) {
        int ans=arr[0];
        int count=0;
        int n=arr.length;
        for(int i=0; i<n; i++){
             if(count==0){
                ans=arr[i];
            } 
            if(arr[i]==ans)
            count++;
            else count--;
        }
        return ans;
    }
}
