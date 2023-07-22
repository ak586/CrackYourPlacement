package day13.binarySum;

 class Solution {
    public String addBinary(String a, String b) {

        String ans="";
        int carry=0;
        int m=a.length();
        int n=b.length();
        int i=m-1;
        int j=n-1;
        while(i>=0 && j>=0){
            int x=a.charAt(i)-'0';
            int y=b.charAt(j)-'0';
            int sum=x+y+carry;
            if(sum==2||sum==0) ans="0"+ans;
            else {
                ans="1"+ans;
            }
            carry=sum>1?1:0;
            i--;
            j--;
        }

        while(i>=0){
            int sum=carry+ a.charAt(i)-'0';
            if(sum==2){
                ans="0"+ans;
                carry=1;
            }
            else{
                if(sum==0)
                ans="0"+ans;
                else ans="1"+ans;
                carry=0;
            }
            i--;
        }
        while(j>=0){
            int x=b.charAt(j)-'0';
            int sum=x+carry;
            if(sum==2){
                carry=1;
                ans="0"+ans;
            }
            else{
                carry=0;
                if(sum==0) ans="0"+ans;
                else ans="1"+ans;
                carry=0;
            }
            j--;
        }
        if(carry!=0) ans="1"+ans;
        return ans;
    }
}
