package day04.spiralMatrix;

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++)
                ans.add(mat[top][j]);
            top++;
            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);
            right--;
// if single row is present
            if (top <= bottom)
                for (int j = right; j >= left; j--)
                    ans.add(mat[bottom][j]);
            bottom--;
                    
                    // if single column is present
            if (left <= right)
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);
            left++;
        }
        return ans;
    }
}
