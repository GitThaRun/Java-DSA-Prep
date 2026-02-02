// Problem statement : Given an integer array of size n containing distinct values in the range from 0 to n (inclusive), return the only number missing from the array within this range.

// Example 1
// Input: nums = [0, 2, 3, 1, 4]
// Output: 5
// Explanation:
// nums contains 0, 1, 2, 3, 4 thus leaving 5 as the only missing number in the range [0, 5]

// Platform : Striver
// Level : Easy
// Approaches : 
// 1)Brute Force : Time Complexity : O(N ^ 2), Space Complexity : O(1)
// 2)Better Approach (Better) : Time Complexity : O(N) , Space Complexity : O(N);
// 3)Optimal Approach1 : Time Complexity : O(N) , Space Complexity : O(1)
// 4)Optimal Approach2 : Time Complexity : O(N), Space Complexity : O(1)
import java.util.HashMap;
import java.util.Scanner;

public class Find_Missing_Number {
    // Brute Force Approach
    public static int bruteGetNumber(int[] arr){

        int N = arr.length;
        for(int i = 0;i <= N;i++){
            boolean isFound = false;
            for(int j = 0;j < N ;j++){
                if(arr[j] == i){
                    isFound = true;
                    break;
                }
            }
             if(!isFound){
                return i;
            }
        } 
        return N;
    }

    // Better Approach
    public static int betterGetNumber(int[] arr){
        int N = arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int e : arr){
            map.put(e, e);
        }

        for(int i = 0; i <= N;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return N;
    }

    // Optimal Approach1
    public static int getNumberOptimal(int[] arr){
        int N = arr.length;

        int sum = N * (N + 1) / 2;
        int required = 0;
        for(int i = 0;i < N;i++){
            required += arr[i];
        } 

        return sum - required;
    }

    // Optimal Appraoch2
    public static int optimalGetNumber(int[] arr){
        int N = arr.length;

        int xor1 = 0; int xor2 = 0;
        for(int i = 0;i < N;i++){
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ arr[i];
        }
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(bruteGetNumber(nums));
        System.out.println(betterGetNumber(nums));
        System.out.println(getNumberOptimal(nums));
        System.out.println(optimalGetNumber(nums));
        sc.close();
    }
}
