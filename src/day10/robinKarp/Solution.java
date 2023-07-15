package day10.robinKarp;

public class Solution {

    static int q = 5381;

    public static int hash(String str, int n) {
        int base = 1;
        int ans = 0;
        for (int i = n; i >= 0; i--) {
            ans += base * (str.charAt(i) - 'A' + 1);
            ans = ans % q;
            base = base * 26;
        }
        return ans;
    }

    public static boolean compare(int i, int j, String str, String pattern) {
        int k = 0;
        for (; i <= j; i++) {
            if (str.charAt(i) != pattern.charAt(k)) 
                return false;
            k++;    
        }
        return true;
    }
    
    

    public static int robinKarp(String str, String pattern) {

        int m = str.length();
        int n = pattern.length();
        // patternsize is more than text size
        if (n > m)
            return -1;
        int patternHash = hash(pattern, n - 1);
        int currHash = 0;
        int i=0;
        int j=n-1;
        while(j<m){
            if(j<n-1){
                j++;
                continue;
            }
            if (j == n - 1)
                currHash = hash(str, n - 1);
            // System.out.println(currHash+" "+i+" "+j);
            if(currHash==patternHash &&compare(i,j,str, pattern)){
                return i;
            }
            else {
                if (j == m - 1)
                    return -1;
                
                // finding next hash value in constant time using hoiner's  rule
                int chToRemove = str.charAt(i)-'A'+1;
                int chToAdd = str.charAt(j + 1) - 'A' + 1;
                int remove = (int) Math.pow(26, n - 1) * chToRemove;
                int nextHash = (currHash - remove) % q;
                nextHash = (nextHash * 26 + chToAdd) % q;
                currHash = nextHash;
                i++;
                j++;              
            }

        }
        return -1;

    }
    public static void main(String[] args) {
        System.out.println(robinKarp("AABAAC", "BAA"));
        System.out.println(robinKarp("ABC", "A"));
    }
}
