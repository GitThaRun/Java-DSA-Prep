// A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
// You must write an algorithm that runs in O(log n) time.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.

// Platform : Leetcode
// Level : Medium

// Approches
// 1)BruteForce : Time Complexity : O(n), Space Complexity : O(1)
// 2)Optimal : Time Complexity : O(log n), Space Complexity : O(1)
import java.util.Scanner;
public class Peak_Element {
    public static int bruteFindPeak(int[] nums){
        int n = nums.length;

        for(int i = 0;i < n;i++){
            boolean left = (i == 0 || nums[i] >= nums[i - 1]);
            
            boolean right = (i == n - 1 || nums[i] >= nums[i + 1]);

            if(left && right) return i;
        }
        return -1;
    }
    public static int optimalFindPeak(int[] nums){
        int low = 0, high = nums.length - 1;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[mid + 1]){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        // int res = bruteFindPeak(nums);
        // System.out.println(res);

        int res = optimalFindPeak(nums);
        System.out.println(res);

        sc.close();
    }
}
