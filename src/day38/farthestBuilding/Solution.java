package day38.farthestBuilding;

class Solution {

    // using dp
    // public int helper(int i, int bricks, int ladder, int heights[]){
    // if(i==heights.length-1) return i;
    // int curr=heights[i];
    // int next=heights[i+1];
    // if(next>curr){
    // int ans1=i;
    // int ans2=i;
    // if(bricks>next-curr) ans1=helper(i+1, bricks-(next-curr), ladder, heights);
    // if(ladder>0) ans2=helper(i+1, bricks, ladder-1, heights);
    // int ans=Math.max(ans1, ans2);
    // return ans;
    // }
    // else {
    // return helper(i+1, bricks, ladder, heights);
    // }
    // }

    // use bricks first and if there are not enough bricks then use ladder and replace previousoly used brick
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans = 0;
        // keep track of maximum jumps
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int n = heights.length - 1;
        while (i < n) {
            int curr = heights[i];
            int next = heights[i + 1];
            int d = next - curr;

            if (d <= 0)
                i++;
            else {
                if (bricks >= d) {
                    bricks -= d;
                    i++;
                } else {
                    if (ladders <= 0)
                        break;
                    if (maxHeap.size() > 0) {

                        if (d >= maxHeap.peek()) {
                            // if current difference is highest then use ladder and as we can't replace a
                            // ladder with bricks so don't add it in the heap
                            ladders--;
                            i++;
                            continue;
                        } else {
                            ladders--;
                            bricks += maxHeap.poll();
                            continue;
                        }
                    } else {
                        ladders--;
                        i++;
                    }
                }
                maxHeap.add(d);
            }
        }
        return i;
    }
}
