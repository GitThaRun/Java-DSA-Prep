public class DecimalToBinary {
    public static String conversion(int num){
        StringBuilder binary = new StringBuilder();
        while(num > 0){
            binary.insert(0, num % 2);
            num /= 2;
        }
        return binary.toString();
    }
    public static void main(String[] args) {
        int x = 5;

        System.out.println(conversion(x));
    }
}
