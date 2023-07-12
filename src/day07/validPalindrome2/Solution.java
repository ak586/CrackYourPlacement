package day07.validPalindrome2;

class Solution {
   
   public  boolean isPalindrome(String s, int i, int j){
       while(i<j){
           if(s.charAt(i)!=s.charAt(j)) return false;
           i++;
           j--;
       }
       return true;
   }
   
   
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else {
                // incase of mismatch we have two option to remove ith or jth character . So we need to try both
                return isPalindrome(s, i+1, j)|| isPalindrome(s, i,j-1);
            }
        }
        return true;
        
    }
}
