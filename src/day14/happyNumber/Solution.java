package day14.happyNumber;

class Solution {
    public int helper(int n){
        int temp=0;
            while(n!=0){
                temp+=Math.pow(n%10,2);
                n=n/10;
            }
            return temp;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=helper(slow);
            fast=helper(helper(fast));
        }while(slow!=fast);
        return slow==1;
    }
}
