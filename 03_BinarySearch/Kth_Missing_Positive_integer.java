// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
// Return the kth positive integer that is missing from this array.

// Example 1:
// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

// Platform: LeetCode
// Level: Easy
// Approach: Binary Search
// Time Complexity: O(log n), where n is the length of the array.
// Space Complexity: O(1)

public class Kth_Missing_Positive_integer {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int missing = arr[mid] - (mid + 1);

            if(missing < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
    public static void main(String[] args) {
        Kth_Missing_Positive_integer obj = new Kth_Missing_Positive_integer();
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(obj.findKthPositive(arr, k)); 
    }
}
