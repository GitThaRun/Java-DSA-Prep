public class BitIsSetOrNot {
    public static boolean checkIthBit(int num,int i){
        // Left Shift
        // return ((num & (1 << i )) != 0);

        // Right Shift
        return ((num >> i) & 1) == 1;
    }
    public static void main(String[] args) {
        int num = 13, i = 2;
        System.out.println(checkIthBit(num, i));
    }
}
