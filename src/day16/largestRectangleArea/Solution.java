package day16.largestRectangleArea;

import java.util.*;

class Solution
{
    
    public static long getMaxArea(long hist[], long n) 
    {
        // next min to left
        int leftMin[] = new int[(int) n];
        // next min to right
        int rightMin[]=new int[(int)n];
        int i=0;
        Stack<Integer>st=new Stack<>();
        while(i<n){
            if(st.size()==0){
                leftMin[i]=-1;
            }
             else if(st.size()>0 && hist[st.peek()]<hist[i]) leftMin[i]=st.peek();
            else{
                while(st.size()>0 && hist[st.peek()]>=hist[i]){
                    st.pop();
                }
                if(st.size()==0) leftMin[i]=-1;
                else {
                    leftMin[i]=st.peek();
                }
            }
            st.push(i);
            i++;
        }
        
        
        // System.out.println(Arrays.toString(leftMin));
        
        
        i=(int)n-1;
        st.clear();
        while(i>=0){
            if(st.size()==0) rightMin[i]=(int)n;
           else if(st.size()>0 && hist[st.peek()]<hist[i]) rightMin[i]=st.peek();
            else{
                while(st.size()>0 && hist[st.peek()]>=hist[i])
                    st.pop();
                if( st.size()==0) rightMin[i]=(int)n;
                else rightMin[i]=st.peek();
            }
            st.push(i);
            i--;
        }
        
        
        long ans=0;
        for(i=0; i<n; i++){
            long len=hist[i];
            long l=leftMin[i];
            long r=rightMin[i];
            long w=r-l-1;
            if(w<=0) w=1;
            long area=len*w;
            ans=Math.max(area, ans);
        }
        
        return ans;
        
        
    }
        
}
