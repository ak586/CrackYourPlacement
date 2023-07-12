package day07.longestcommonprefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen=Integer.MAX_VALUE;
        int minInd=0;
        for(int i=0; i<strs.length; i++){
            if(strs[i].length()<minLen){
                minInd=i;
                minLen=strs[i].length();
            }
        }
        String commonPrefix=strs[minInd];
        for(int i=0; i<strs.length; i++){
            for(int j=0; j<strs[i].length() && j<minLen; j++){
                if(strs[i].charAt(j)!=commonPrefix.charAt(j)){
                    minLen=j;
                    break;
                }
            }
        }
        return commonPrefix.substring(0,minLen);
    }
}
