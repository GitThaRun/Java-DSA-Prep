// You are given an integer n. You need to find all the divisors of n. Return all the divisors of n as an array or list in a sorted order.
// A number which completely divides another number is called it's divisor.

// Example 1

// Input: n = 6
// Output = [1, 2, 3, 6]

// Time Complexity: O(n), where n is the input number. This is because we are checking for all numbers from 1 to n to see if they are divisors of n.

// Space Complexity: O(k), where k is the number of divisors of n. This is because we are storing the divisors in a list.

import java.util.ArrayList;
import java.util.List;

public class PrintAllDivisors {
    public static int[] divisors(int n) {

        List<Integer> divisors = new ArrayList<>();

        for(int i = 1;i <= n;i++){
            if(n % i == 0){
                divisors.add(i);
            }
        }

        int[] result = new int[divisors.size()];

        for(int i = 0;i < divisors.size();i++){
            result[i] = divisors.get(i);
        }

        return result;
    }
    public static void main(String[] args) {
        int n = 6;
        int[] result = divisors(n);

        for(int divisor : result){
            System.out.print(divisor + " ");
        }
    }
}
