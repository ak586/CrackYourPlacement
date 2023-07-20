package day11.IntegerToEnglish;

import java.util.*;

class Solution {

static String ones[]={"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
static String tens[]={"", "Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
static String tens2[]={"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public static String helper(int arr[]){
        String ans="";
       if(arr[0]>0){
           ans+=ones[arr[0]]+" "+"Hundred";
       }
       if(arr[1]>0){
             if(arr[1]==1 && arr[2]>0){
                 if(ans.length()>0)
                ans+=" "+tens2[arr[2]];
                else ans+=tens2[arr[2]];
                return ans;
            }
            else{
            if(ans.length()>0) ans=ans+" "+tens[arr[1]];
                else ans+=tens[arr[1]];
            }

       }
       if(arr[2]>0){
           if(ans.length()>0) ans=ans+" "+ones[arr[2]];
           else ans+=ones[arr[2]];
       }
        return ans;
    }
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int part[]=new int[3];
        int j=0;
        List<String> ans=new ArrayList<>();
        while(num!=0){
            part[0]=0;
            part[1]=0;
            part[2]=0;
            for(int i=0; i<3; i++){
                part[2-i]=num%10;
                num=num/10;
            }
            ans.add(helper(part));

        }
        Collections.reverse(ans);

        String suffix[]={"", "Thousand", "Million", "Billion"};
        String st="";
        for(int i=0; i<ans.size(); i++){
            if(ans.get(i)=="") continue;
            if(st.length()>0) st+=" ";
            st+=ans.get(i);
            if(st.length()>0 && ans.size()-i-1!=0) st+=" ";
            st+=suffix[ans.size()-i-1];
        }

        return st;

    }
}
