// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

// Platform : Leetcode
// Level : Hard
// Time Complexity : O(n! + s * n^2), where s is no of solutions, n^2 is no of characters
// Space Complexity : O(n^2), excluding output

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    private static void solve(int col,int n,char[][] board,
                              int[] leftRow,int[] lowerDiagonal,
                              int[] upperDiagonal,List<List<String>> result
    ){
        if(col == n){
            List<String> temp = new ArrayList<>();
            
            for(int i = 0;i < n;i++){
                temp.add(new String(board[i]));
            }
            result.add(temp);

            return;
        }

        for(int row = 0;row < n;row++){
            if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 &&
                upperDiagonal[n - 1 + col - row] == 0
            ){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, n, board, leftRow, lowerDiagonal, upperDiagonal, result);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] c : board){
            Arrays.fill(c,'.');
        }
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];

        solve(0,n,board,leftRow,lowerDiagonal,upperDiagonal,result);

        return result;
    }
    public static void main(String[] args) {
        int n = 4;

        List<List<String>> ans = solveNQueens(n);
        System.out.print("[");

    for (int i = 0; i < ans.size(); i++) {
        System.out.print("[");

        List<String> board = ans.get(i);

        for (int j = 0; j < board.size(); j++) {
            System.out.print(board.get(j));

            if (j < board.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.print("]");

        if (i < ans.size() - 1) {
            System.out.print(",");
        }
    }

    System.out.println("]");
}
}
