// Problem Statement: ou're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1]. The floor of x is the largest element in the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x

// Examples

// Example 1:
// Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
// Result: 4 7
// Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

// Platform : Sttriver's Sheet
// Level : Easy

// Time Complexity : O(log n), Space Complexity : O(1)
import java.util.Scanner;
public class Floor_And_Ceil {
    public static int findFloor(int[] nums,int x){
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] <= x){
                ans = nums[mid];
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findCeil(int[] nums,int x){
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] >= x){
                ans = nums[mid];
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int[] getFloorAndCeil(int[] nums,int x){
        int f = findFloor(nums, x);
        int c = findCeil(nums, x);

        return new int[] {f,c};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        
        int result[] = getFloorAndCeil(arr, x);
        System.out.print("The floor and ceil are : " + result[0] + " " + result[1]);
        sc.close();
    }
}
