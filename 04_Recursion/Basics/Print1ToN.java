// Input: N = 4
// Output: 1, 2, 3, 4
// Explanation: All the numbers from 1 to 4 are printed.

// Platform : Striver SDE Sheet
// Level : Easy
// Time Complexity : O(N), Space Complexity : O(1)

public class Print1ToN {
    
    // Forward Recursion
    public static void printNumbers(int current,int n){
        if(current > n){
            return;
        }
        System.out.print(current + " ");

        printNumbers(current + 1, n);
    }

    // Backward Recursion
    public static void printNum(int current,int n){
        if(current > n){
            return;
        }

        printNum(current + 1, n);
        System.out.print(current + " ");
    }
    public static void main(String[] args) {
        int n = 10;

        printNumbers(1, n);
        System.out.println();
        printNum(1, n);
    }
}
