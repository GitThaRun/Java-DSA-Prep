/**
*Problem: Given an array arr[]. Your task is to find the minimum and maximum elements in the array.

Examples:

Input: arr[] = [1, 4, 3, 5, 8, 6]
Output: [1, 8]
Explanation: minimum and maximum elements of array are 1 and 8.

Input: arr[] = [12, 3, 15, 7, 9]
Output: [3, 15]
Explanation: minimum and maximum element of array are 3 and 15.

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 109

* Platform: GeeksForGeeks
* Difficulty: Easy
*
* Approaches:
* 1)Brute Force -> Time : O(n logn), Space: O(1)
* 2)Optimal Approach -> Time : O(n), Space: O(1) 
*
*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class Max_Min {
	
    // Brute Force Approach
     public static int[] findMaxMin(int[] arr){
        Arrays.sort(arr);

        int max = arr[arr.length - 1];
        int min = arr[0];

        return new int[] {max,min};
     }

     // Optimal Approach
     public static ArrayList<Integer> getMaxMin(int[] arr){
        
        if(arr == null || arr.length == 0 ) return new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int e : arr){
            max = Math.max(max,e);
            min = Math.min(min,e);
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(min);
        result.add(max);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0;i < N;i++){
            arr[i] = sc.nextInt();
        }

        int[] result = findMaxMin(arr);
        System.out.println("Maximum and Minimum are : "+Arrays.toString(result));

        ArrayList<Integer> res = getMaxMin(arr);
        System.out.println("Minimum And Maximum are: " + res);
        sc.close();
    }
}