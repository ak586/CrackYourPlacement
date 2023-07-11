package day06.possiblePermutations;

import java.util.*;

public class Solution {

    public static void printCombination(int arr[], int r[], int ind, int rind) {
     
        if (rind == r.length) {
            for (int a : r)
                System.out.print(a + " ");
            System.out.println();
            return;
        }
        if (ind >= arr.length)
            return;

            int temp = r[rind];
            r[rind] = arr[ind];
            printCombination(arr, r,  ind+1, rind + 1);
            r[rind] = temp;
            // Remove duplicates
    while (ind+1<arr.length && arr[ind] == arr[ind+1])
           ind++;
            printCombination(arr,r, ind+1,rind);
        
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 4 };
        int r[] = new int[2];
        Arrays.sort(arr);
        printCombination(arr, r, 0, 0);

    }
}