package day14.reverseInteger;


class Solution {
    // public int reverse(int x) {
    //     long ans=0;
    //     while(x!=0){
    //         ans=ans*10 + x%10;
    //         if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE ) return 0;
    //         x=x/10;
    //     }
    //     return (int)ans;

    // }

    public int reverse(int x){
        int ans=0;
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        while(x!=0){
            if(ans>max/10 || (ans==max && x%10>max%10))
            return 0;
            if(ans<min/10 || (ans==min  && x%10<min%10)) return 0;
            ans=ans*10+x%10;
            x=x/10;
        }
        return ans;
    }
}
