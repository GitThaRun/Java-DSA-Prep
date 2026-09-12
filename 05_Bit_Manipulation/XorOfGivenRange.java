// Given two integers L and R. Find the XOR of the elements in the range [L , R].

// Examples
// Example 1:
// Input :
// L = 3 , R = 5
// Output :
// 2

// Platform : SDE Sheet
// Level : Medium 
// Time Complexity : O(1), Space Complexity : O(1)
public class XorOfGivenRange {
    private static int tillN(int n){
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n + 1;
        if(n % 4 == 3) return 0;

        return n;
    }
    public static int findRangeXor(int l,int r){
        return tillN(l - 1) ^ tillN(r);
    }
    public static void main(String[] args) {
        int l = 3,r = 5;

        System.out.println(findRangeXor(l, r));
    }
}
