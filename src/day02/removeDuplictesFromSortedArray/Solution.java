package day02.removeDuplictesFromSortedArray;

class Solution {
    // use two pointer approach
    public int removeDuplicates(int[] arr) {
        int i=0;
        int j=0;
        int n=arr.length;
        while(j<n){
          if(arr[i]==arr[j]){
              j++;
          }
          else{
              i++;
              int temp=arr[i];
              arr[i]=arr[j];
              arr[j]=temp;
              j++;
          }
        }
        


        return i+1;
    }
}
