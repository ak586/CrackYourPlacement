package day14.palindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int temp=x;
        int reverse=0;

        while(temp!=0){
            reverse=reverse*10+temp%10;
            temp=temp/10;
        }
        return x==reverse;
    }
}
