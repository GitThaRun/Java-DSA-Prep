// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(log(m*n)) , Space Complexity : O(1)

public class Search_In_2D_Matrix {
    public static boolean searchMatrix(int[][] nums,int target){

        int m = nums.length;
        int n = nums[0].length;

        int low = 0, high = (n * m) - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int row = mid / n;
            int col = mid % n;

            if(nums[row][col] == target) return true;

            else if(nums[row][col] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}
