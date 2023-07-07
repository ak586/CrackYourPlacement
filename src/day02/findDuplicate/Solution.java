package day02.findDuplicate;

// Time complexity:O(n)

// Space complexity:O(n)

// Note we can use the given array as the map but question doesn't allow to modify it

// Proof: pigenhole principle : n+1 holes and n numbers i.e atleast one number will be repeated

class Solution {
    public int findDuplicate(int[] arr) {
        int ans=arr[0];
       int map[]=new int[arr.length+1];
        for(int i=0; i<arr.length; i++){
           if(map[arr[i]]==1) return arr[i];
           map[arr[i]]++;
        }
        return ans;
    }
}
