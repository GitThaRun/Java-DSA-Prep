// Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

// Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

// Example 1:

// Input: g = [1,2,3], s = [1,1]
// Output: 1

// Platform : Leetcode
// Level : Easy

// Time Complexity: O(nlogn + mlogm), where n is the number of children and m is the number of cookies. This is because we are sorting both the greed factor array and the cookie size array.

// Space Complexity: O(1), as we are using constant space.
import java.util.Arrays;
public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if(s.length == 0) return 0;

        int p1 = 0,p2 = 0;
        while(p1 < g.length && p2 < s.length){
            if(s[p2] >= g[p1]){
                p1++;
            }
            p2++;
        }
        return p1;
    }
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int result = findContentChildren(g,s);
        System.out.println(result);
    }
}
