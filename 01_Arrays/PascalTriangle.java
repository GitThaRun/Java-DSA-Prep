
// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly 

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// Platform : Leetcode
// Level : Easy
// Time Complexity : O(numRows^2), Space Complexity : o(numsRows ^ 2);
import java.util.ArrayList;
import java.util.List;
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows;i++){
            List<Integer> rows = new ArrayList<>();
            
            for(int j = 0;j <= i;j++){
                if(j == 0 || j == i){
                    rows.add(1);
                }
                else{
                    int val = result.get(i - 1).get(j - 1) + 
                              result.get(i - 1).get(j);
                    rows.add(val);
                }
            }
            result.add(rows);
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;

        List<List<Integer>> ans = generate(numRows);

        for(List<Integer> l : ans){
            System.out.print("[ ");
            for(int r : l){
                System.out.print(r + " ");
            }
            System.out.println("]");
        }
    }
}
