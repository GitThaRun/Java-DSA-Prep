// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

// Platform : Leetcode
// Level : Medium

// Approaches
// 1)BruteForce : Time Complexity : O(n ^ 2), Space Complexity : O(N)
// 2)Optimal : Time Complexity : O(n ^ 2), Space Complexity : O(1)

public class Rotate_Array_By_90Deg {
    public static int[][] bruteRotate(int[][] matrix){
        int n = matrix.length;

        int[][] rotated = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void optimalRotate(int[][] matrix){
        int n = matrix.length;

        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0;i < n;i++){
            int left = 0, right = n - 1;

            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        // int[][] res = bruteRotate(matrix);
        // for(int[] row : res){
        //     for(int val : row){
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }
        optimalRotate(matrix);
        for(int[] row : matrix){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
