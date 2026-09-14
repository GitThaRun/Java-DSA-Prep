// Time Complexity : O(√n)
// Space Complexity : O(1) 

public class CheckPrimeOrNot {
    public static void main(String[] args) {
        int n = 36;
        int count = 0;

        for(int i = 1;i * i <= n;i++){
            if(n % i == 0){
                count++;

                if(n / i != i){
                    count++;
                }
            }
            if(count >= 2) break;
        }
        if(count == 2){
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }
    }
}
