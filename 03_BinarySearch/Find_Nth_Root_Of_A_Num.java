// Problem Statement: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.

// Examples
// Input: N = 3, M = 27
// Output: 3
// Explanation: The cube root of 27 is equal to 3.

// Platform : Striver SDE Sheet
// Level : Easy
// Approach : Binary Search On Answers
// Time Complexity : O(log2 M) * log2 N, Space Complexity : O(1)

public class Find_Nth_Root_Of_A_Num {
    public static int NthRoot(int n, int m){
        int low = 1, high = m;

        while(low <= high){
            int mid = low + (high - low) / 2;
            long ans = 1;

            for(int i = 0; i < n; i++){
                ans *= mid;
                if(ans > m) break;
            }

            if(ans == m){
                return mid;
            }
            else if(ans < m){
                low = mid + 1;
                ans = mid;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 4, m = 69;
        System.out.println(NthRoot(n, m));
    }
}
