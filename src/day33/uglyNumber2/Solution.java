package day33.uglyNumber2;

class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        int i=0;
        pq.add((long)1);
        while(i<n-1){
            long curr=pq.remove();
            while(pq.size()>0 && pq.peek()==curr)pq.remove();
            pq.add(curr*5);
            pq.add(curr*3);
            pq.add(curr*2);
            i++;
        }
        long ans=pq.remove();
        return (int)ans;
    }
}
