// Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and wants to reach at coordinates (n-1, n-1).

// Find all possible paths that rat can take to travel from (0, 0) to (n-1, n-1). The directions in which rat can move are 'U' (up) , 'D' (down) , 'L' (left) , 'R' (right).

// The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling, whereas value 1 represents that rat can travel through the cell. If the cell (0, 0) has 0 value, then mouse cannot move to any other cell.

// Note :

// In a path no cell can be visited more than once.
// If there is no possible path then return empty vector.

// Example 1
// Input : n = 4 , grid = [ [1, 0, 0, 0] , [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1] ]
// Output : [ "DDRDRR" , "DRDDRR" ]

// Platform : Leetcode
// Level : Hard
// Time Complexity : O(N^2 * 3^N^2), Space Complexity :O(N ^ 2) excluding output 

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    private static void solve(int row,int col,int[][] grid,int n,List<String> result,
                  String move,int[][] v,int[] rowi,int[] colj){

                    if(row == n - 1 && col == n - 1){
                        result.add(move);

                        return;
                    }
                    String dir = "DLRU";

                    for(int i = 0;i < 4;i++){
                        int nexti = row + rowi[i];
                        int nextj = col + colj[i];

                        if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n
                            && v[nexti][nextj] == 0 && grid[nexti][nextj] == 1){
                                v[row][col] = 1;

                                solve(nexti,nextj,grid,n,result,move + dir.charAt(i),v,rowi,colj);
                                v[row][col] = 0;
                        }
                    }
                }
    public static List<String> findPath(int[][] grid) {
        int n = grid.length;
        List<String> result = new ArrayList<>();
        int[][] visited = new int[n][n];

        int[] rowi = {1,0,0,-1};
        int[] colj = {0,-1,1,0};

        if(grid[0][0] == 1){
            solve(0,0,grid,n,result,"",visited,rowi,colj);
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1,0,0,0},
            {1,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };

        List<String> ans = findPath(grid);

        System.out.println(ans);
    }
}
