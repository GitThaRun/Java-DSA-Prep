public class SetTheBit {
    public static int setIthBit(int num,int i){

        return (num | (1 << i));
    }
    public static void main(String[] args) {
        int num =9, i = 2;
        System.out.println(setIthBit(num, i));
    }
}
