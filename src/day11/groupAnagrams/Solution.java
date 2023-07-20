package day11.groupAnagrams;
import java.util.*;


// sort each word and use a map to keep track of answer lists

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
    int n=string_list.length;
       List<List<String>> ans=new ArrayList<>();
       HashMap<String , List<String>>map=new HashMap<>();
       for(int i=0; i<n; i++){
           
           char arr[]=string_list[i].toCharArray();
           Arrays.sort(arr);
           String temp= new String(arr);
           
           if(map.containsKey(temp)){
               List<String>currAns=map.get(temp);
               currAns.add(string_list[i]);
               map.put(temp, currAns);
           }
           else{
              List<String> currAns=new ArrayList<>();
              currAns.add(string_list[i]);
               map.put(temp, currAns);
           }
       }
       
       for(String str: map.keySet()){
           ans.add(map.get(str));
       }
       return ans;
       
    }
}
