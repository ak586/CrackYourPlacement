package day05.mergeSortedArrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n==0) return ;
        if(m==0){
            for(int i=0; i<n; i++)
            nums1[i]=nums2[i];
        }
        int i=m-1;
        int j=n-1;
        int k = m + n - 1;
        // start placint heigher element at the end
        while(i>=0 && j>=0 && k>=0)
        {
            if(nums1[i]>nums2[j]){
                nums1[k--]=nums1[i];
                i--;
            }
            else {
                nums1[k--]=nums2[j];
                j--;
            }
        }
// remaining elements   
while(j>=0){
    nums1[k]=nums2[j];
    k--;
    j--;
}

    }
}
