package day27.kthLargestElement;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        int i=0;
        while(i<k){
            minHeap.add(nums[i++]);
        }
        while(i<nums.length){
            if(nums[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
            i++;
        }
        // System.out.println(minHeap);
        return minHeap.poll();
    }
}
