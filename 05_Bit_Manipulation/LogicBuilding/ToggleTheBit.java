public class ToggleTheBit {
    public static int toggleIthBit(int num,int i){
        return (num ^ (1 << i));
    }
    public static void main(String[] args) {
        int num = 13, i = 2;
        System.out.println(toggleIthBit(num, i));
    }
}
