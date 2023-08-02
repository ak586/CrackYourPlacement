package day24.permutations;
// daily problem
class Solution {
    static List<List<Integer>>ans;
    void helper(int []nums, int ind){
        if(ind==nums.length){
            List<Integer> ls =new ArrayList<>();
            for(int a: nums) ls.add(a);
            ans.add(ls);
            return ;
        }
        for(int i=ind; i<nums.length; i++){
            // swap two elements
            int temp=nums[ind];
            nums[ind]=nums[i];
            nums[i]=temp;
            // done with the current index so ind+1 , not i be careful
            helper(nums, ind+1);
            // swap back to original place
            temp=nums[ind];
            nums[ind]=nums[i];
            nums[i]=temp;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        helper(nums, 0);
        return ans;
    }
}
