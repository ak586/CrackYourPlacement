package day26.postfixEvaluator;

class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    
    {
        Stack<Integer> st=new Stack<>();
        // int ans=0;
        for(int i=0 ; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                st.push(s.charAt(i)-'0');
            }
            else{
                char op=s.charAt(i);
                int b=st.pop();
                int a=st.pop();
                if(op=='+') st.push(a+b);
                if(op=='-') st.push(a-b);
                if(op=='/') st.push(a/b);
                if(op=='*') st.push(a*b);
            }
        }
        return st.peek();
    }
}
