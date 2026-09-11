public class RemoveTheLastSetBit {
    public static int removeLastBit(int num){
        return (num & num - 1);
    }
    public static void main(String[] args) {
        int num = 16;
        System.out.println(removeLastBit(num));
    }
}
