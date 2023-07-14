package day09.SmallestWindowAllCharacters;

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static boolean checkCondition(int map1[], int map2[]){
        for(int i=0; i<26; i++){
            if(map1[i]>map2[i]) return false;
        }
        return true;
    }
    public static String smallestWindow(String s, String p)
    {
        int map1[]=new int[26];
        for(int i=0; i<p.length(); i++){
            map1[p.charAt(i)-'a']++;
        }
        
        int ans=s.length();
        int map2[]=new int[26];
        int i=0;
        int j=0;
        int ansI=0;
        int ansJ=0;
        boolean found=false;
        int n=s.length();
        while(j<n){
            // calculation
            map2[s.charAt(j)-'a']++;
            // condition satisfied
                while(i<=j && checkCondition(map1,map2)){
                    // remove calculations
                    found=true;
                    int temp=j-i+1;
                    if(temp<ans) {
                        ansI=i;
                        ansJ=j;
                    }
                    ans=Math.min(j-i+1, ans);
                    map2[s.charAt(i)-'a']--;
                    i++;
                }
                j++;
        }
        if(!found) return "-1";
        return s.substring(ansI, ansJ+1);
        
    }
}
