package day15.excelSheetColumnTitle;

import java.util.*;
class Solution {
    public String convertToTitle(int columnNumber) {
        ArrayList<Integer> arr=new ArrayList<>();
        int n=columnNumber;
        while (n > 0) {
            //  this number system consists of digits 1 to 26 that's why we are doing n-- here 
            // by doing this we changed the range from 1 to 26 to 0 to 25
            n--;
            arr.add(n%26);
            n=n/26;
        }
        // System.out.println(arr);
        String ans="";
        for(int i=arr.size()-1; i>=0; i--){
            ans+=(char)('A'+arr.get(i));
        }
        return ans;
        
    }
}
