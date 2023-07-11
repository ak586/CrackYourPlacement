package day06.countInversions;

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.

   
   static long merge(int start, int mid,int end, long arr[] ){
         if(start==end) return 0;
         long temp[]=new long[end-start+1];
         int i=start;
         int j=mid+1;
         int k=0;
         long ans=0;
         while(i<=mid && j<=end){
             if(arr[i]<=arr[j]){
                 temp[k]=arr[i];
                 i++;
             } 
             else {
                // all the next elements will be greater than arr[j] beacause array is sorted
                ans+=mid-i+1;
                 temp[k]=arr[j];
                 j++;
             }
             k++;
         }
         
        while(i<=mid){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while(j<=end){
            temp[k]=arr[j];
            k++;
            j++;
        }
        k=0;
         for( i=start; i<=end; i++)
         arr[i]=temp[k++];
        return ans;
     }
    static long mergeSort(int start, int end, long arr[]){
        long ans=0;
        if(start<end){
        int mid=(end-start)/2+start;
       long ans1= mergeSort(start, mid, arr);
       long ans2= mergeSort(mid+1, end, arr);
        ans+=merge(start,mid, end, arr)+ans1+ans2;
        }
        return ans;
    }
    
    
    static long inversionCount(long arr[], long N)
    {
        long ans =mergeSort(0,(int)N-1, arr);
        return ans;
    }
}
