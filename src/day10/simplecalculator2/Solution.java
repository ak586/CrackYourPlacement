package day10.simplecalculator2;

import java.util.*;

class Solution {

    public boolean isOperator(char ch){
        return ch=='+'|| ch=='-'|| ch=='*'||ch=='/';
    }

    public String toPostfix(String str){
        HashMap<Character , Integer> map=new HashMap<>(5);
        map.put('+', 1);
        map.put('-', 1);
        map.put('/', 2);
        map.put('*', 2);
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int i=0;
        int n=str.length();
        while(i<n){
            char ch=str.charAt(i);
            if(ch==' '){
                i++;
                continue;
            }    
     if(isOperator(ch)){
                sb.append(" ");
                while(st.size()>0 && map.get(st.peek())>=map.get(ch)){
                    sb.append(st.pop());
                }
                st.push(ch);
            }
            else sb.append(ch);
            i++;
        }
        while(st.size()>0) sb.append(st.pop());
        return sb.toString();
    }


    public int evaluatePostfix(String str){
        Stack<Integer>st=new Stack<> ();
        int i=0;
        int n=str.length();

        while(i<n){
            char ch=str.charAt(i);
            if(str.charAt(i)==' '){
                i++;
                continue;
            }
            if(isOperator(ch)){
                int a=st.pop();
                int b=st.pop();
                if(ch=='+') st.push(b+a);
                if(ch=='-') st.push(b-a);
                if(ch=='/') st.push(b/a);
                if(ch=='*') st.push(b*a);
                i++;
            }
            else {
                String temp="";
                char chr=str.charAt(i);
                while(Character.isDigit(chr)){
                    temp+=chr;
                    i++;
                    if(i>=n) break;
                    chr=str.charAt(i);
                }
                st.push(Integer.valueOf(temp));
            }
        }
        return st.peek();
    }


    public int calculate(String s) {
        String postfix=toPostfix(s);
        int ans= evaluatePostfix(postfix);
        
        return ans;
    }
}
