// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given the sorted rotated array nums of unique elements, return the minimum element of this array.

// You must write an algorithm that runs in O(log n) time.

// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.
import java.util.Scanner;
public class Minimum_In_Sorted_Array {
    public static int bruteFindMin(int[] nums){
        int ans = Integer.MAX_VALUE;

        for(int i = 0;i < nums.length;i++){
            ans = Math.min(ans,nums[i]);
        }
        return ans;
    }

    public static int optimalFindMin(int[] nums){
        int low = 0,high = nums.length - 1;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        // int res = bruteFindMin(nums);
        int res = optimalFindMin(nums);
        System.out.println(res);
        sc.close();
    }
}
