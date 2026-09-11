public class BinaryToDecimal {
    public static int conversion(String binary){
        int decimal = 0;
        int length = binary.length();

        for(int i = length - 1;i >= 0;i--){
            if(binary.charAt(i) == '1'){
                decimal += Math.pow(2, length - 1 - i);
            }
        }
        return decimal;
    }
    public static void main(String[] args) {
        String binary = "101";

        System.out.println(conversion(binary));
    }
}
