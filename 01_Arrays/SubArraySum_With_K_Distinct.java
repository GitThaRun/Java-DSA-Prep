// Problem : You are given an array A of length N and an integer k.
// It is given that a subarray from l to r is considered good, if the number of distinct elements in thatsubarray doesn’t exceed k. Additionally, an empty subarray is also a good subarray and its sum is considered to be zero. Find the maximum sum of a good subarray.

// Sample Output 1
// 12
// Sample Output Description 1
// Here, N = 11, k = 2
// A = [1, 2, 2, 3, 2, 3, 5, 1, 2, 1, 1]
// We can select the subarray = [2, 2, 3, 2, 3]
// It is a good subarray because it contains at most k
// distinct elements.
// Its sum = 2+2+3+2+3 = 12

// Platform : HackWithInfy Sample Questions
// Level : Medium

// Approaches :
// 1)BruteForce : Time Complexity : O(N ^ 2), Space Complexity : O(N)
// 2)Optimal(Sliding Window) : Time Complexity : O(N), Space Complexity : O(N)

import java.util.HashMap;
import java.util.Scanner;

public class SubArraySum_With_K_Distinct {
    
    // BruteForce

    public static int bruteSubArraySum(int[] arr,int k){
        int N = arr.length;
        int maxSum = 0;

        for(int i = 0;i < N;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            int curr_sum = 0;

            for(int j = i;j < N;j++){
                curr_sum += arr[j];

                map.put(arr[j],map.getOrDefault(arr[j],0) + 1);

                if(map.size() <= k){
                    maxSum = Math.max(maxSum,curr_sum);
                }
                else{
                    break;
                }
            }
        }
        return maxSum;
    }

    // Optimal
    public static int optimalSubArraySum(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int N = arr.length;
        int left = 0;
        int maxSum = 0;
        int curr_sum = 0;

        for(int right = 0;right < N;right++){
            
            map.put(arr[right],map.getOrDefault(arr[right], 0) + 1);
            curr_sum += arr[right];

            while(map.size() > k){
                map.put(arr[left],map.get(arr[left]) - 1);

                curr_sum -= arr[left];

                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            maxSum = Math.max(curr_sum,maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        // System.out.println(bruteSubArraySum(nums, K));
        System.out.println(optimalSubArraySum(nums, K));
        sc.close();
    }
}
