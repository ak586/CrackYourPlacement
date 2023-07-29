package day20.combinations;

class Solution {

    static List<List<Integer>> ans;
    void helper(int n, int k, List<Integer> ls){
        if(k==0){
            ans.add(new ArrayList<>(ls));
            return ;
        } 
        if(n==0){
            return ;
        }
        ls.add(n);
        helper(n-1, k-1,ls);
        ls.remove(ls.size()-1);
        helper(n-1, k, ls);
    } 
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        helper(n, k, new ArrayList<>());
        return ans;
    }
}
