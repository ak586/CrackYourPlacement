package day09.simplifyPath;

import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");

        Stack<String> st=new Stack<>();
        int n=parts.length;
        for(int i=0; i<n ; i++){
            if(parts[i].equals(".")) continue;
            if(parts[i].equals("..")){
                if(st.size()>0) st.pop();
            }
            else{
                if(parts[i].length()>0)
                st.push(parts[i]);
            }
        }
        if(st.size()==0) return "/";
        StringBuilder ans=new StringBuilder();
        while(st.size()>0){
            ans.insert(0,'/'+st.pop());
        }
        return ans.toString();

    }
}
