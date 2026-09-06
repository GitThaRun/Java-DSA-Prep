// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Platform : Leetcode
// Level : Medium
// Time complexity : O(N * 3^L) , Space Complexity : O(L) , where N is the number of cells in the board and L is the length of the word

public class WordSearch {
    private static boolean search(char[][] board,String word,int row,int col,int idx){
        if(idx == word.length()){
            return true;
        }

        if(row < 0 || row >= board.length || 
           col < 0 || col >= board[0].length){
            return false;
           }

        if(board[row][col] != word.charAt(idx)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean isFound = 
            search(board,word,row - 1,col,idx + 1) ||
            search(board,word,row + 1,col,idx + 1) ||
            search(board,word,row,col - 1,idx + 1) ||
            search(board,word,row,col + 1,idx + 1);

        board[row][col] = temp;

        return isFound;
    }
    public static boolean exist(char[][] board, String word) {
        for(int row = 0;row < board.length;row++){
            for(int col = 0;col < board[0].length;col++){
                if(board[row][col] == word.charAt(0)){

                    if(search(board,word,row,col,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
}
