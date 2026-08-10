// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
// The test cases are generated so that there will be an answer.

// Example 1:

// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

// Platform: LeetCode
// Level: Medium
// Approach: Binary Search
// Time Complexity: O(n log m), where n is the length of the array and m is the maximum value in the array.
// Space Complexity: O(1)

public class Find_Smallest_Divisor{
     private int minSum(int[] nums,int div){
        int sum = 0;

        for(Integer i : nums){
            sum += (i + div - 1) / div;
        }
        return sum;
    }

    private int getMax(int[] nums){
        int max = Integer.MIN_VALUE;

        for(Integer num : nums){
            max = Math.max(max,num);
        }
        return max;
    }
    public int smallestDivisor(int[] nums, int threshold) {

        if(nums.length > threshold) return -1;

        int low = 1;
        int high = getMax(nums);

        while(low <= high){
            int mid = low + (high - low)  / 2;

            int CurrDiv = minSum(nums,mid);

            if(CurrDiv <= threshold){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }

        }
        return low; 
    }
    public static void main(String[] args) {
        Find_Smallest_Divisor obj = new Find_Smallest_Divisor();
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println(obj.smallestDivisor(nums, threshold)); 
    }
}