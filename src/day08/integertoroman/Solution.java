package day08.integertoroman;

class Solution {
    public String intToRoman(int num) {
        String [] roman={"M", "CM", "D", "CD", "C", "XC", "L" ,"XL", "X", "IX", "V","IV","I"};
        int []in={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String ans="";
        int i=0;
        while(num!=0){
           while(num>=in[i] ){
               ans+=roman[i];
               num-=in[i];
           }
           i++;
        }
        return ans;
    }
}
