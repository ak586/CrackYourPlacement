package day02.sort012;

class Solution {
    public void sortColors(int[] arr) {
        //  Dutch National Flag algorithm: Three pointer partitioning
        int n=arr.length;
        int left=0;
        int mid=0;
        int right=n-1;
        while (mid <= right) {
            
            if (arr[mid] == 0) {
                // swap low with mid
               int temp=arr[mid];
               arr[mid]=arr[left];
               arr[left]=temp;
               left++;
               mid++;
            }
            else if (arr[mid] == 2) {
                // swap high with mid
                int temp=arr[mid];
                arr[mid]=arr[right];
                arr[right]=temp;
                right--;
            }
            else mid++;
        }
    }
}
