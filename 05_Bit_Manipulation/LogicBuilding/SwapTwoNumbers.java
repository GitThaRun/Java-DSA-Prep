public class SwapTwoNumbers {
    public static int[] swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a,b};
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        System.out.println("Before swapping: a = " + a + ", b = " + b);
        int[] swapped = swap(a, b);
        System.out.println("After swapping: a = " + swapped[0] + ", b = " + swapped[1]);
    }
}
