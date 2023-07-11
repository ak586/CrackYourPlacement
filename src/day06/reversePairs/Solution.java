package day06.reversePairs;


class Solution {


 static int  merge(int start, int mid,int end, int arr[] ){

        int i=start;
        int j=mid+1;
        int ans=0;
        for(; i<=mid; i++){
            while(j<=end){
                long temp=arr[j];
                if(arr[i]>2*temp)
                j++;
                else break;
            } 
            ans+=j-(mid+1);
        }
        
        i=start;
        j=mid+1;
        int k=0;
        int temp[]=new int[end-start+1];
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k]=arr[i];
            k++;
            i++;
        }
        while(j<=end){
            temp[k]=arr[j];
            k++;
            j++;
        }
        k=0;
        for(i=start; i<=end; i++){
            arr[i]=temp[k];
            k++;
        }
        
        return ans;
        
     }


    public int mergeSort(int start, int end, int []nums){
        int ans=0;
        if(start<end){
            int mid=(end-start)/2+start;
            ans+=mergeSort(start, mid, nums);
            ans+=mergeSort(mid+1, end, nums);
            ans+=merge(start, mid, end, nums);

        }
        return ans;
    }
    public int reversePairs(int[] nums) {
        
       int ans= mergeSort(0, nums.length-1, nums);
       return ans;
    }
}
