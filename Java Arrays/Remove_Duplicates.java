// Problem Statement : Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique element appears only once.

// Return the number of unique elements in the array.

// Example 1
// Input: nums = [0, 0, 3, 3, 5, 6]
// Output: 4
// Explanation:
// Resulting array = [0, 3, 5, 6, _, _]
// There are 4 distinct elements in nums and the elements marked as _ can have any value.

// Example 2

// Input: nums = [-2, 2, 4, 4, 4, 4, 5, 5]
// Output: 4
// Explanation:
// Resulting array = [-2, 2, 4, 5, _, _, _, _]
// There are 4 distinct elements in nums and the elements marked as _ can have any value.

//Platform : Strivers SDE Sheet
//Difficulty: Easy
// Approaches:
// 1)Brute Force -> Time : O(n log n + n), Space: O(n)
// 2)Optimal Approach -> Time : O(n), Space: O(1)

import java.util.HashSet;
import java.util.Scanner;

public class Remove_Duplicates {

    // Brute Force Approach
    public static int removeDuplicates(int[] nums){

        HashSet<Integer> set = new HashSet<>();
        for(int e : nums){
            set.add(e);
        }
        // return set.size();
        int idx = 0;
        for(Integer k : set){
            nums[idx] = k;
            idx++;
        }
        return idx;
    }

    // Optimal Approach
    public static int uniqueElements(int[] nums){
        if (nums == null || nums.length ==0) return 0;
        int start = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] != nums[start]){
                start++;
                nums[start] = nums[i];
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
         
      int N = sc.nextInt();

      int[] nums = new int[N];
      System.out.println("Enter " + N + " Elements : ");
      for(int i = 0;i < N;i++){
        nums[i] = sc.nextInt();
      }

      int result = uniqueElements(nums);
      System.out.println(result);
      for(int i = 0;i < result;i++){
        System.out.print(nums[i] + " ");
      }
      sc.close();
    }
}
