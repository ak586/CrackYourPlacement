package day18.ceilingInSortedArray;

class Solution {
    
    int getFloor(int arr[], int n, int x){
        int ans=-1;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(arr[mid]<x){
                ans=arr[mid];
                low=mid+1;
            }
            else if(arr[mid]==x) return arr[mid];
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    
    int getCeil(int arr[], int n, int x){
        int ans=-1;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(arr[mid]==x)return x;
            else if(arr[mid]>x){
                ans=arr[mid];
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
    
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        Arrays.sort(arr);
       int floor=getFloor(arr, n, x);
       int ceil=getCeil(arr, n, x);
    //   System.out.println(floor+" "+ceil);
       return new Pair(floor, ceil);
    }
}
