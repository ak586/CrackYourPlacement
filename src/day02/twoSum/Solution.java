package day02.twoSum;

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int ans[]={0,0};
        for(int i=0; i<nums.length; i++){
            int y=target-nums[i];
            if(map.containsKey(y)){
                ans[0]=map.get(y);
                ans[1]=i;
                break;
            }
            map.put(nums[i],i);

        }
        return ans;
    }
}
