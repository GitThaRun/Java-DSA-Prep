// Problem Statement: You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.

// Examples
// Example 1:
// Input:
//  N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
// Output
// 4

// Platform : Striver sheet
// Level : Easy

// Approaches 
// 1)BruteForce Approach : Time Complexity : O(N), O(1)
// 2)Optimal Approach : Time Complexity : O(2 * log N), O(1)
import java.util.Scanner;
public class Count_Occurrences {
    public static int bruteCount(int[] nums,int x){
        int count = 0;

        for(int i = 0;i < nums.length;i++){
            if(nums[i] == x){
                count++;
            }
        }
        return count;
    }
    public static int firstOccurrence(int[] nums,int x){
        int first = -1;
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == x){
                first = mid;
                high = mid - 1;
            }
            else if(nums[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return first;
    }

    public static int lastOccurrence(int[] nums,int x){
        int last = -1;
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == x){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return last;
    }
    public static int[] getFirstAndLast(int[] nums,int x){
        int first = firstOccurrence(nums, x);

        if(first == -1){
            return new int[] {-1,-1};
        }
        int last = lastOccurrence(nums, x);

        return new int[] {first,last};
    }
    public static int optimalCount(int[] nums,int x){
        int[] res = getFirstAndLast(nums, x);

        if(res[0] == -1) return 0;

        return (res[1] - res[0] + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        // int res = bruteCount(arr, x);
        // System.out.println(res);
        
        int result = optimalCount(arr, x);
        System.out.println(result);
        sc.close();
    }
}
