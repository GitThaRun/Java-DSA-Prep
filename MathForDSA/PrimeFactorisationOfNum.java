// You are given an integer array queries of length n.
// Return the prime factorization of each number in array queries in sorted order.

// Example 1

// Input : queries = [2, 3, 4, 5, 6]
// Output : [ [2], [3], [2, 2], [5], [2, 3] ]

// Time Complexity: O(n * sqrt(m)), where n is the length of the queries array and m is the maximum number in the queries array. This is because for each number, we are checking for factors up to its square root.

// Space Complexity: O(n * k), where n is the length of the queries array and k is the average number of prime factors for each number. This is because we are storing the prime factors for each number in a list.

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorisationOfNum {
     public static List<List<Integer>> primeFactors(int[] queries) {
            List<List<Integer>> res = new ArrayList<>();

            for(int num : queries){
                List<Integer> factors = new ArrayList<>();

                for(int i = 2;i * i <= num;i++){
                    while(num % i == 0){
                        factors.add(i);
                        num /= i;
                    }
                }

                if(num > 1){
                    factors.add(num);
                }
                res.add(factors);
            }

            return res;
        }
    public static void main(String[] args) {
        int[] queries = {2,3,4,5,6};
        List<List<Integer>> result = primeFactors(queries);

        System.out.println(result);
    }
}
