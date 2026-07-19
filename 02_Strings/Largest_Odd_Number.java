
import java.util.Scanner;
public class Largest_Odd_Number {
    public static String largestOddNumber(String num) {
        int idx = -1;

        int i;
        for(i = num.length() - 1;i >= 0;i--){
            if((num.charAt(i) - '0') % 2 == 1){
                idx = i;
                break;
            }
        }
        if(idx == -1) return "";

        i = 0;
        while(i <= idx && num.charAt(i) == '0') i++;

        return num.substring(i,idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        System.out.println(largestOddNumber(num));
        sc.close();
    }
}
