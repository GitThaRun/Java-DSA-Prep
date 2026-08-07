// Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated.

// Input : arr = [4,5,6,7,0,1,2,3]
// Result: 4
// Explanation: The original array should be [0,1,2,3,4,5,6,7]. So, we can notice that the array has been rotated 4 times.

// Platform : Striver SDE Sheet
// Level : Easy
// Approach : Binary Search
// Timme Complexity : O(log n), Space Complexity : O(1)

public class Find_How_Many_Times_Array_Rotated {
    public static int FindRotated(int[] nums){
        int low = 0, high = nums.length - 1;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]){
                low = mid + 1;
            }

            else{
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};

        System.out.println(FindRotated(nums));
    }
}
