package day19.sortByReversingSubArray;

import java.util.* ;


public class Solution {

	
 
	public static boolean sortArr(int n, int[] arr) {
        int i = 1;
    //   find first occurance of decreasing sub array
	  while(i<n){
		  if(arr[i-1]>arr[i]){
			  --i;
			  break;
		  } 
		  i++;
	  }
	  int j=i;
	  while(j<n-1 && arr[j]>arr[j+1])j++;
      //   System.out.println(i+" "+j);
    // reverse that part of the subarray
    while (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
    //   check if the array is sorted after reversing or not
	  for( i=0; i<n-1; i++){
		  if(arr[i+1]<arr[i]) return false;
	  }
	  return true;
	}

}

