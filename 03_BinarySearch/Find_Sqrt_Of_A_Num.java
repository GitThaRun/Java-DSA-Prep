// Problem Statement: You are given a positive integer n. Your task is to find and return its square root. If ‘n’ is not a perfect square, then return the floor value of sqrt(n).

// Examples
// Input: N = 36
// Output: 6
// Explanation: Square root of 36 is 6. 

// Platform : Striver SDE Sheet
// Level : Easy
// Approach : Binary Search On Answers
// Time Complexity : O(log n), Space Complexity : O(1)

public class Find_Sqrt_Of_A_Num {
    public static int mySqrt(int num){
        int low = 0, high = num;
        int ans = 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(mid * mid <= num){
                low = mid + 1;
                ans = mid;
            }
            else{
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        int num = 36;
        System.out.println(mySqrt(num));
    }
}
