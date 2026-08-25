// Input: N=5
// Output: 15
// Explanation: 1+2+3+4+5=15

// Platform : Striver SDE Sheet
// Level : Easy
// Time Complexity : O(N), Space Complexity : O(1)

public class SumOfNNaturalNum {
    public static int NNumbersSum(int n){
        if(n == 1){
            return 1;
        }
        return n + NNumbersSum(n - 1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(NNumbersSum(n));
    }
}
