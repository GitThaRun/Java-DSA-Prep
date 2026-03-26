// Problem Statement: Reverse an array arr[]. Reversing an array means rearranging the elements such that the first element becomes the last, the second element becomes second last and so on.

// Examples:

// Input: arr[] = [1, 4, 3, 2, 6, 5]  
// Output:  [5, 6, 2, 3, 4, 1]
// Explanation: The first element 1 moves to last position, the second element 4 moves to second-last and so on.

// Input: arr[] = [4, 5, 1, 2]
// Output: [2, 1, 5, 4]
// Explanation: The first element 4 moves to last position, the second element 5 moves to second last and so on.

// Difficulty: Easy
//Platform: GeeksForGeeks
// Approaches:
// 1)Brute Force -> Time : O(n), Space: O(n)
// 2)Optimal Approach -> Time : O(n), Space: O(1)

import java.util.*;
public class Reverse_Array {
    
    // Brute Force Approach
    public static int[] ReverseArray(int[] arr){

        int[] temp = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            temp[i] = arr[arr.length - i - 1];
        }

        for(int i = 0;i < arr.length;i++){
            arr[i] = temp[i];
        }
        return arr;
    }

    // Optimal Approach
    public static int[] GetReverseArray(int[] arr){

        if(arr == null || arr.length == 0) return arr;
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
             int temp = arr[left];
             arr[left] = arr[right];
             arr[right] = temp;

             left++;
             right--;
        }
        return arr;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println("Enter " + N + " Elements : ");
        int[] arr = new int[N];

        for(int i = 0;i < N;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Reversed Array using Brute Force : " + Arrays.toString(ReverseArray(arr.clone())));
        System.out.println("Reversed Array using optimal Approach : " + Arrays.toString(GetReverseArray(arr.clone())));

        sc.close();
    }
}
