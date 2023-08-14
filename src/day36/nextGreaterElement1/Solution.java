package day36.nextGreaterElement1;

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int i=nums2.length-1;
        HashMap<Integer, Integer> map=new HashMap<>();
        while(i>=0){
            while(st.size()>0 && st.peek()<=nums2[i])st.pop();
            if(st.size()==0) map.put(nums2[i],-1);
            else map.put(nums2[i], st.peek());
            st.push(nums2[i]);
            i--;
        }
        int finalAns[]=new int[nums1.length];
        i=0;
        for(int a: nums1){
            finalAns[i]=map.get(a);
            i++;
        }

        return finalAns;
    }
}
