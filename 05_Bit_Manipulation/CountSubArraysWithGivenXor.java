// Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.
// Input: A = [4, 2, 2, 6, 4] , k = 6
// Output: 4

// Platform : Striver SDE Sheet
// Level : Medium
// Time Complexity(Brute Force): O(n^2), Space Complexity : O(1)
// Time Complexity(Optimal): O(n), Space Complexity : O(n)

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithGivenXor {
    // BruteForce
    public static int bruteCountSubarraysXor(int[] A,int k){
        int n = A.length;

        int count = 0;
        for(int i = 0;i < n;i++){
            int xorval = 0;
            for(int j = i;j < n;j++){
                xorval ^= A[j];

                if(xorval == k){
                    count++;
                }
            }
        }
        return count;
    }

    // Optimal
    public static int countSubarraysXor(int[] A,int k){
        int count = 0;
        int n = A.length;
        int prefixXor = 0;
        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,1);
        for(int i = 0;i < n;i++){
            prefixXor ^= A[i];

            int req = prefixXor ^ k;

            count += map.getOrDefault(req,0);

            map.put(prefixXor,map.getOrDefault(prefixXor,0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {4,2,2,6,4};
        int k = 6;

        // System.out.println(bruteCountSubarraysXor(nums, k));
        System.out.println(countSubarraysXor(nums, k));
    }
}
