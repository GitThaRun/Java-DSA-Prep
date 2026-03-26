// Problem Statement : In a Bus stop queue there are 'N' groups of people in it.In every group there are a[i] people in it.Every 30min an empty bus arrives at the bustop and it can carry atmost 'M' people in it.
// Note that the order of queue never changes 
// Yout task is to count the number of buses required to transport all the groups to Jeju Island.

// Input :
// 4
// 3
// 2 3 2 1
// Output : 
// 3
// Time Complexity : O(N), Space Complexity : O(1)

import java.util.Scanner;
public class Buses_Required {
    
    public static int countBuses(int arr[],int M){

        int count = 1;
        int load = 0;

        for(int i = 0;i < arr.length;i++){
            if(load + arr[i] <= M){
                load += arr[i];
            }
            else{
                count++;
                load = arr[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int people[] = new int[N];
        for(int i = 0;i < N;i++){
            people[i] = sc.nextInt();
        }

        System.out.println(countBuses(people,M));
        sc.close();
    }
}
