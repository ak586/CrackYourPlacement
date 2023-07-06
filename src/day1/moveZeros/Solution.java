package day1.moveZeros;


//  brute force
// copy all non zero elements  int an  array



// two pointer approach
// start with i and j pointers if you find at j is a non-negative element then swap if with it pointer
// this will move all zeros to the end and the order will also be maintained
class Solution {
    public void moveZeroes(int[] arr) {
        int n=arr.length;
        int i=0;
        int j=0;
        while( j<n){
            if( arr[j]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
          j++;
        }
    }
}