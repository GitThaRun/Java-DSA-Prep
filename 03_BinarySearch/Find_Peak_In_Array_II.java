// A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
// Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
// You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
// You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

// Example 1:
// Input: mat = [[1,4],[3,2]]
// Output: [0,1]
// Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

// Platform: Leetcode
// Level: Medium
// Time Complexity: O(m log(n)) or O(n log(m)), Space Complexity: O(1)

public class Find_Peak_In_Array_II {
     private static int findMax(int[][] mat,int m,int col){
        int max = -1, idx = -1;

        for(int i = 0;i < m;i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                idx = i;
            }
        }
        return idx;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0, high = n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int maxRowIdx = findMax(mat,m,mid);

            int left = mid - 1 >= 0?mat[maxRowIdx][mid - 1] : -1;
            int right = mid + 1 < n?mat[maxRowIdx][mid + 1] : -1;

            if(mat[maxRowIdx][mid] > left && mat[maxRowIdx][mid] > right){
                return new int[] {maxRowIdx,mid};
            }
            else if(mat[maxRowIdx][mid] < left){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int[][] mat = {{1,4},{3,2}};

        int[] ans = findPeakGrid(mat);

        System.out.println(ans[0] + " " + ans[1]);
    }
}
