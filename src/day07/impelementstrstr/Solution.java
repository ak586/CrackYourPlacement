package day07.impelementstrstr;


class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int k = needle.length();
        if (haystack.equals(needle))
            return 0;
        for (int i = 0; i < n - k + 1; i++) {
            String temp = haystack.substring(i, i + k);
            if (temp.equals(needle))
                return i;
        }
        return -1;
    }
}

/* KMP implementation remaining will optimise it later */
