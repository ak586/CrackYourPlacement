package day27.topKfrequentElement;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a: nums){
            if(map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }
            else map.put(a, 1);
        }
    // this max heap will store the elements as per their frequency 
    PriorityQueue<Integer>heap=new PriorityQueue<>((key1, key2)->(map.get(key2)-map.get(key1)));
    for(int a: map.keySet()) heap.add(a);
    int ans[]=new int[k];
    int i=0;
    while(k>0){
        ans[i++]=heap.poll();
        k--;
    }
    return ans;
    }
}
