// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.

// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
// Output: true

// Platform: Leetcode
// Level: Medium
// Time Complexity: O(m + n), Space Complexity: O(1)

public class Search_In_2D_Matrix_II {
    public static boolean searchMatrix(int[][] nums,int target){
        int m = nums.length;
        int n = nums[0].length;

        int row = 0;
        int col = n - 1;

        while(row < m && col >= 0){
            if(nums[row][col] == target) return true;

            else if(nums[row][col] < target){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;

        System.out.println(searchMatrix(matrix, target));
    }
}
