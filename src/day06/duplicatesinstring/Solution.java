package day06.duplicatesinstring;

import java.util.*;

public class Solution {
   public static void printDuplicate(String str) {
        int map[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++)
        {
            if (map[i] > 1) {
                 char ch= (char)((int)'a'+i);
                System.out.println(ch+" "+map[i]);
            }
        }
    }
    public static void main(String[] args) {
        printDuplicate("aaabjeecdd");
    }
}
