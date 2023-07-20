package day11.minimumWindow;


class Solution {
    boolean checkCondition(int map[], int patMap[]){
        for(int i=0; i<128; i++){
            if(patMap[i]>map[i])
            return false;
        }
        return true;
    }

// sliding window problem
    public String minWindow(String s, String t) {
        int map[]=new int[128];
        int patMap[]=new int[128];
        for(int i=0; i<t.length(); i++){
            patMap[t.charAt(i)]++;
        }
        int i=0;
        int j=0;
        int n=s.length();
        int start=-1;
        int end=-1;
        int ans=Integer.MAX_VALUE;

        while(j<n){
            // preprocessing
            map[s.charAt(j)]++;

            // condition satisfied get answer and remove calculations
                while(checkCondition(map, patMap) && i<=j){
                    if(ans>j-i+1){
                        ans=j-i+1;
                        start=i;
                        end=j;
                    }
                    map[s.charAt(i)]--;
                    i++;
                }
            j++;
        }
        
        if(start==-1) return  "";
        return s.substring(start, end+1);
    }
}
