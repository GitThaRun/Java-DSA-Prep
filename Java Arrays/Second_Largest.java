// Problem Statement: Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.

// Examples
// Example 1:
// Input:
//  [1, 2, 4, 7, 7, 5]  
// Output:
  
// Second Smallest : 2  
// Second Largest : 5  
// Explanation:
//   The elements are sorted as 1, 2, 4, 5, 7, 7.  
// Hence, the second smallest element is 2, and the second largest element is 5.

// Example 2:
// Input:
//  [1]  
// Output:
  
// Second Smallest : -1  
// Second Largest : -1  
// Explanation:
//   Since there is only one element in the array, it is both the largest and smallest element.  
// Therefore, there is no second smallest or second largest element present.

// Difficulty: Easy
// Approaches:
// 1)Brute Force -> Time : O(n logn), Space: O(1)
// 2)Optimal Approach -> Time : O(n), Space: O(1) 

import java.util.*;
public class Second_Largest {
    
    // BruteForce Approach
    public static int findSecondLargest(int[] arr){
        Arrays.sort(arr);
        
        int largest = arr[arr.length - 1];
        int secondLargest = -1;
        for(int i = arr.length - 2;i >= 0;i--){
            if(arr[i] != largest){
                secondLargest = arr[i];
                break;
            }
        }
        return secondLargest;
    }

    public static int GetSecondLargest(int[] arr){

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int e : arr){
            if(e > firstMax){
                secondMax = firstMax;
                firstMax = e;
            }
            else if(e < firstMax && e > secondMax){
                secondMax = e;
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];

        System.out.println("Enter " + N + " elements : ");

        for(int i = 0;i < N;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Second Largest using Brute Force : " + findSecondLargest(arr));
        System.out.println("Second Largest using Optimal Approach : " + GetSecondLargest(arr));

        sc.close();
    }
}
