package day05.validParenthesis;

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(st.size()>0){
            char top=st.peek();
            char curr=s.charAt(i);
            if((top=='{' && curr=='}') ||(top=='(' && curr==')') || ( top=='[' && curr==']')) {
                st.pop();
                i++;
                continue; //skip current character
            }
            }   
            st.push(s.charAt(i));
            i++;
          
            

        }
        return st.isEmpty();
    }
}
