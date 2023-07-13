package day08.generateParenthesis;

import java.util.*;
class Solution {

    public static void helper(int open , int close, List<String>ans,String curr){
        if(open<0 || close <0) return ;
            if(open==0 && close==0)
            ans.add(curr);
    // System.out.println(curr+" "+open+" "+close);
    if(open>0)
    helper(open-1, close, ans,curr+"(");
    if(close>open)
    helper(open, close-1, ans,curr+")");
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        helper(n, n, ans, "");
        return ans;
    }
}
