package day31.searchInSortedAndRotatedArray;

class Solution 
{ 
    static int Search(int array[], int target)
	{
	   int low=0;
	   int high=array.length-1;
	   while(low<=high){
	       int mid=(high-low)/2+low;
	       if(array[mid]==target)return mid;
	       //when left half is sorted
	       else if(array[low]<array[mid]){
	           if(target<array[mid] && target>=array[low]) high=mid-1;
	           else low=mid+1;
	       }
	       // when right half is sorted
	       else{
	           if(target>array[mid] && target<=array[high]) low=mid+1;
	           else high=mid-1;
	       }
	   }
	   return -1;
	}
} 
