// Given an integer array of size n, find all elements that appear more than ⌊n / 3⌋ times.
// Example 1:

// Input: nums = [3,2,3]
// Output: [3]

// Platform : Leetcode
// Level : Medium
// Approaches:
// 1)Time Complexity : O(N),Space Complexity : O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Majority_Element_II {
    // Better
    public static List<Integer> betterMajorityElement(int[] nums){
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        int target = n / 3 + 1;

        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);

            if(map.get(nums[i]) == target){
                result.add(nums[i]);
            }

            if(result.size() > 2) break;
        }
        return result;
    } 

    // Optimal
    public static List<Integer> optimalMajorityElement(int[] nums){
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for(int i = 0;i < n;i++){
            if(cnt1 == 0 && nums[i] != ele2){
                ele1 = nums[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0 && nums[i] != ele1){
                ele2 = nums[i];
                cnt2 = 1;
            }
            else if(nums[i] == ele1){
                cnt1++;
            }
            else if(nums[i] == ele2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int c1 = 0,c2 = 0;
        for(int i = 0;i < n;i++){
            if(ele1 == nums[i]){
                c1++;
            }
            if(ele2 == nums[i]){
                c2++;
            }
        }
        int target = n / 3 + 1;
        if(c1 >= target){
            ans.add(ele1);
        }
        if(c2 >= target && ele1 != ele2){
            ans.add(ele2);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,1,3};

        // List<Integer> ans = betterMajorityElement(nums);
        List<Integer> ans = optimalMajorityElement(nums);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
