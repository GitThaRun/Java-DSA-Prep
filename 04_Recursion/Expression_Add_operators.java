// Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.
// Note that operands in the returned expressions should not contain leading zeros.
// Note that a number can contain multiple digits.


// Example 1:

// Input: num = "123", target = 6
// Output: ["1*2*3","1+2+3"]
// Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

// Platform : Leetcode
// Level : Hard
// Time complexity : O(N * 6 ^ N), Space Complexity : O(N * 6 ^ N) with result space 

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_operators {
    private static void addOperators(
                String num,
                int target,
                int idx,
                StringBuilder expression,
                long val,
                long prev,
                List<String> result){

                    if(idx == num.length()){
                        if(val == target){
                            result.add(expression.toString());
                        }
                        return;
                    }

                    for(int i = idx;i < num.length();i++){
                        if(num.charAt(idx) == '0' && i > idx){
                            break;
                        }

                        String part = num.substring(idx,i + 1);
                        long curr = Long.parseLong(part);

                        int lenBefore = expression.length();

                        if(idx == 0){
                            expression.append(part);

                            addOperators(num,target,i + 1,expression,curr,curr,result);

                            expression.setLength(lenBefore);
                        }
                        else{
                            // +
                            expression.append("+").append(part);

                            addOperators(num,target,i + 1,expression,val + curr,curr,result);

                            expression.setLength(lenBefore);
                            // -
                            expression.append("-").append(part);

                            addOperators(num,target,i + 1,expression,val - curr,-curr,result);

                            expression.setLength(lenBefore);

                            // *
                            expression.append("*").append(part);

                            addOperators(num,target,i + 1,expression,val - prev + prev * curr,prev * curr,result);

                            expression.setLength(lenBefore);
                        }
                    }
                }
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        addOperators(num,target,0,new StringBuilder(),0,0,result);

        return result;
    }
    public static void main(String[] args) {
        String num = "123";
        int target = 5;

        List<String> ans = addOperators(num, target);

        System.out.print("[");
        for(int i = 0;i < ans.size();i++){
            System.out.print(ans.get(i));

            if(i < ans.size() - 1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
