package day34.CountSmallerElementAfterSelf;


class Pair{
    int val;
    int index;
    Pair(int v, int i){
        val=v;
        index=i;
    }
}

class Solution {
    static int ans[];
    
    void merge(int start, int end, int mid, Pair arr[]){
        int n=end-start+1;
        Pair temp[]=new Pair[n];
        int i=start;
        int j=mid+1;
        int count=0;
        int k=0;
       while(i<=mid && j<=end){
           int num1=arr[i].val;
           int ind1=arr[i].index;
           int num2=arr[j].val;
           int ind2=arr[j].index;
           if(num1>num2){
               if(ind1<ind2)
                count++;
                temp[k++]=arr[j++];
           }
           else{
               temp[k++]=arr[i++];
               ans[ind1]+=count;
           }
       }
        
        while(i<=mid){
            ans[arr[i].index]+=count;
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }
        k=0;
        for(i=start; i<=end; i++){
            arr[i]=temp[k++];
        }
    }
    
    void mergeSort(int start, int end, Pair arr[]){
        if(start<end){
            int mid=start+(end-start)/2;
            mergeSort(start, mid, arr);
            mergeSort(mid+1, end, arr);
            merge(start, end, mid, arr);
        }
    }
    
    
    int[] constructLowerArray(int[] arr, int n) {
        ans=new int [n];
       Pair ar[]=new Pair[n];
       for(int i=0; i<n; i++){
           ar[i]=new Pair(arr[i], i);
       }
       mergeSort(0, n-1, ar);
       return ans;
    }
}