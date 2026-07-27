// Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix..

// Examples
// Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

// Platform : Leetcode
// Level : Medium
// Approaches:
// 1)BruteForce : Time Complexity : O(m * n), Space Complexity : O(m + n)

public class Set_Matrix_Zeroes {
    public static void bruteSetZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rows = new int[m];
        int[] cols = new int[n];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    rows[i] = -1;
                    cols[j] = -1;
                }
            }
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(rows[i] == -1 || cols[j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void optimalSetZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstColZero = false;

        for(int i = 0;i < m;i++){
            if(matrix[i][0] == 0) firstColZero = true;

            for(int j = 1;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = m-1;i >= 0;i--){
            for(int j = n-1;j >= 1;j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(firstColZero){
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] m = {{1,1,1},{1,0,1},{1,1,1}};

        // bruteSetZeroes(m);
        optimalSetZeroes(m);
        for(int[] row : m){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
