// Given an array of nums of n integers. Every integer in the array appears twice except one integer. Find the number that appeared once in the array.


// Example 1
// Input : nums = [1, 2, 2, 4, 3, 1, 4]
// Output : 3
// Explanation : The integer 3 has appeared only once.

// Example 2
// Input : nums = [5]
// Output : 5
// Explanation : The integer 5 has appeared only once.

// Platform : Stivers SDE Sheet
// Difficulty : Easy
// Approaches :
// 1) Brute Force -> Time : O(n^2), Space : O(1)
// 2)Hashing -> Time : O(n), Space : O(n)
// 3)Bit Manipulation : O(n), space : O(1)
import java.util.HashMap;
import java.util.Scanner;
public class Single_Number {
    
    public static int bruteSingleNumber(int[] nums){

       int N = nums.length;

       for(int i = 0;i < N;i++){
        int num = nums[i];
        int count = 0;
        for(int j = 0;j < N;j++){
            if(nums[j] == num){
                count++;
            }
        }
         if(count == 1){
            return num;
        }
       }
       return N;
    }

    public static int betterSingleNumber(int[] nums){

        HashMap<Integer,Integer> map = new HashMap<>();

        int N = nums.length;
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for(int idx : map.keySet()){
            if(idx == 1){
                return idx;
            }
        }
        return N;
    }
    public static int optimalSingleNumber(int[] nums){

        int xorr = 0;
        int N = nums.length;
        for(int i = 0;i < N;i++){
            xorr = xorr ^ nums[i];
        }
        return xorr;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] nums = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        // System.out.println(bruteSingleNumber(nums));
        // System.out.println(betterSingleNumber(nums));
        System.out.println(optimalSingleNumber(nums));
        sc.close();
    }
}
