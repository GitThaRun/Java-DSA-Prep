// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.

// Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
// Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]

// Platform : Leetcode
// Level : Hard
// Time complexity : O(N ^ N ^ 2) , Space Complexity : O(N ^ 2) , where N is the size of the board
public class Sudoku_Solver {
    private static boolean solve(char[][] board){
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){

                if(board[i][j] == '.'){

                    for(char c = '1';c <= '9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;

                            if(solve(board)) return true;

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board,int row,int col,char c){
        for(int i = 0;i < 9;i++){
            if(board[i][col] == c) return false;

            if(board[row][i] == c) return false;
        }
            int boxRow = (row / 3) * 3;
            int boxCol = (col / 3) * 3;

            for(int i = boxRow;i < boxRow + 3;i++){
                for(int j = boxCol;j < boxCol + 3;j++){
                    if(board[i][j] == c) return false;
                }
            }
        return true;
    }
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static void main(String[] args) {
        char[][] board =  {
            {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
            {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
            {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
            {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
            {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
            {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
            {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
            {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
            {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        solveSudoku(board);
        
    for(int i = 0; i < board.length; i++) {
            System.out.print("[");
        for(int j = 0; j < board[0].length; j++) {
            if(j < board[0].length - 1) {
                System.out.print(board[i][j] + ",");
            } else {
                System.out.print(board[i][j]);
            }
        }
        System.out.print("]");
        
        if(i < board.length - 1) {
            System.out.println(",");
        }
    }
    System.out.println("]");
    }
}
