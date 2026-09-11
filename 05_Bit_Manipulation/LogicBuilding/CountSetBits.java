public class CountSetBits {
    public static int countBits(int num){
        if(num == 1) return 1;

        int count = 0;
        while(num > 0){
            count += (num & 1);

            num = num >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 13;

        System.out.println(countBits(n));
    }
}
