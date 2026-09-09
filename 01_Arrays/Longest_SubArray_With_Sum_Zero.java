// You are given an integer array arr of size n which contains both positive and negative integers. Your task is to find the length of the longest contiguous subarray with sum equal to 0.

// Return the length of such a subarray. If no such subarray exists, return 0.

// Example 1
// Input: arr = [15, -2, 2, -8, 1, 7, 10, 23]
// Output: 5

// Platform : Striver SDE Sheet
// Level : Medium
// Time Complexity : O(N), Space Complexity : O(N)

import java.util.HashMap;

public class Longest_SubArray_With_Sum_Zero {
    public static int maxLen(int[] arr) {
        // Your code goes here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;

        int maxlen = 0;

        for(int i = 0;i < arr.length;i++){
            sum += arr[i];

            if(sum == 0){
                maxlen = i + 1;
            }
            else{
                if(map.containsKey(sum)){
                    maxlen = Math.max(maxlen,i - map.get(sum));
                }
                else{
                    map.put(sum,i);
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        int ans = maxLen(arr);

        System.out.println(ans);
    }
}
