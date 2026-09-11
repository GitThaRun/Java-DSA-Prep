public class CheckOddOrNot {
     public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
    public static void main(String[] args) {
        int num = 5;
        System.out.println(isOdd(num));
    }
}
