// Given an m x n matrix, return all elements of the matrix in spiral order.

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Platform : Leetcode
// Level : Medium
// Approaches 
// 1)Time Complexity : O(n * m), Space Complexity : O(1)

import java.util.ArrayList;

public class Spiral_Traversal {
    public static ArrayList<Integer> spiralOrder(int[][] matrix){
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        ArrayList<Integer> result = new ArrayList<>();
        while(top <= bottom && left <= right){
            for(int i = left;i <= right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            for(int i = top;i <= bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right;i >= left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom;i >= top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        ArrayList<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
}
