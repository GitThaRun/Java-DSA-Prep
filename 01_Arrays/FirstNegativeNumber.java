//Problem Statement :  Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

// Note: If a window does not contain a negative integer, then return 0 for that window.

// Examples:

// Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
// Output: [-8, 0, -6, -6]

// Platform : Geeks For Geeks
// Level : Easy
// Approaches:
// 1)Brute Force : Time Complexity : O(n x k) , Space Complexity : O(1)
// 2)Optimal(Sliding Window) : Time Complexity : O(N), Space Complexity : O(k)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FirstNegativeNumber {
    
    // Brute Force
    public static List<Integer> bruteFirstNegative(int arr[],int k){

        ArrayList<Integer> result = new ArrayList<>();
        int N = arr.length;

        for(int i = 0;i <=  N - k;i++){
           boolean isFound = false;

            for(int j = i;j < i + k;j++){
                if(arr[j] < 0){
                    result.add(arr[j]);
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                result.add(0);
            }
        }
        return result;
    }

    // Optimal Approach
    public static List<Integer> optimalFirstNegative(int arr[],int k){

        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int N = arr.length;

        for(int i = 0;i < k;i++){
            if(arr[i] < 0){
                queue.addLast(i);
            }
        }
        if(queue.isEmpty()){
            result.add(0);
        }
        else{
            result.add(arr[queue.peekFirst()]);
        }

        for(int i = k;i < N;i++){

            if(!queue.isEmpty() && queue.peekFirst() <= i - k){
                queue.pollFirst();
            }

            if(arr[i] < 0){
                queue.addLast(i);
            }

            if(queue.isEmpty()){
                result.add(0);
            }
            else{
                result.add(arr[queue.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int nums[] = new int[N];

        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        int K = sc.nextInt();

        // System.out.println(bruteFirstNegative(nums, K));
        System.out.println(optimalFirstNegative(nums, K));
        sc.close();
    }
}