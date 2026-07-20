// Example 1:
// Input:
//  arr = [4, 7, 1, 0]  
// Output:
//  7 1 0  
// Explanation:
//  The rightmost element (0) is always a leader.  
// 7 and 1 are greater than the elements to their right, making them leaders as well.

// Platform : Striver sheet
// Level : Medium

// Approach 
// 1)BruteForce : Time Complexity : O(n ^ 2), Space Complexity : O(1)
// 2)Optimal : Time Complexity : O(n), Space Complexity : O(1)
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Leader {
    public static ArrayList<Integer> bruteLeader(int[] nums){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            boolean isLeader = true;

            for(int j = i + 1;j < nums.length;j++){
                if(nums[j] >= nums[i]){
                    isLeader = false;
                    break;
                }
            }
            if(isLeader){
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static ArrayList<Integer> optimalLeader(int[] nums){
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(nums.length == 0) return ans;

        int max = nums[nums.length - 1];
        ans.add(nums[nums.length - 1]);

        for(int i = nums.length - 2;i >=0;i--){
            if(nums[i] > max){
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        // ArrayList<Integer> ans = bruteLeader(nums);
        // System.out.println(ans);

        ArrayList<Integer> res = optimalLeader(nums);
        System.out.println(res);
        sc.close();
    }
}
