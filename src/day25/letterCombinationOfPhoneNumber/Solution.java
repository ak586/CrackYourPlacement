package day25.letterCombinationOfPhoneNumber;

class Solution {
    static List<String>ans;
    static String map[]={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    void helper(String digits, int ind, String str){
        if(ind==digits.length()){
            ans.add(str);
            return ;
        }
        String val=map[digits.charAt(ind)-'0'];
        String temp=str;
        for(int i=0; i<val.length(); i++){
            str+=val.charAt(i);
            helper(digits, ind+1,str);
            str=temp;
        }
        
    }
    
    public List<String> letterCombinations(String digits) {
        ans=new ArrayList<>();
        if(digits.length()==0)return ans;
        helper(digits, 0, "");
        return ans;
    }
}
