// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:

// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

// Platform : Leetcode
// Level : Medium
// Approches : 
// 1)Better : Time Complexity : O(N ^ 3), Space Complexity : O(N)
// 2)Optimal : Time Complexity : O(N ^ 3), Space Complexity : O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class FourSum {

    // Better
    public static List<List<Integer>> betterFourSum(int[] nums,int target){
        Set<List<Integer>> ans = new HashSet<>();

        int n = nums.length;
        for(int i = 0;i < n - 3;i++){
            for(int j = i + 1;j < n - 2;j++){

                Set<Integer> seen = new HashSet<>();
                for(int k = j + 1;k< n;k++){
                    long req = (int)target - nums[i] - nums[j] - nums[k];

                    if(seen.contains((int)req)){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],(int)req);
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                    seen.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(ans);
    }
    // Optimal
    public static List<List<Integer>> optimalFourSum(int[] nums,int target){
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0;i < n - 3;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1;j < n - 2;j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = n - 1;

                while(left < right){
                    long sum = (long) nums[i] + nums[j];
                    sum += nums[left] + nums[right];

                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        } 

                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }

                        left++;
                        right--;
                    }

                    else if(sum < target) left++;
                    else right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        // List<List<Integer>> res = betterFourSum(nums, target);
        List<List<Integer>> res = optimalFourSum(nums, target);

        for(List<Integer> l  : res){
            System.out.print("[");
            for(int num : l){
                System.out.print(num + ",");
            }
            System.out.print("]");
        }
    }
}
