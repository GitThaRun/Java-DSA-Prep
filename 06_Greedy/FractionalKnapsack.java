// You have n items; the i-th item has value val[i] and weight wt[i].

// A knapsack can carry at most capacity units of weight.

// You may take any fraction of an item (i.e. split items).
// Return the maximum total value that can be placed in the knapsack, rounded to exactly 6 decimal places.

// Example 1

// Input: val = [60,100,120], wt = [10,20,30], capacity = 50
// Output: 240.000000

// Platform : SDE Sheet
// Level : Medium
// Time Complexity : O(n log n), Space Complexity : O(n)
import java.util.Arrays;

public class FractionalKnapsack {

    private static class Item{
        int val;
        int wt;

        Item(int val,int wt){
            this.val = val;
            this.wt = wt;
        }
    }
    public static double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;

        Item[] items = new Item[n];

        for(int i = 0;i < n;i++){
            items[i] = new Item(val[i],wt[i]);
        }

        Arrays.sort(items,(a,b) ->{
            double r1 = (double) a.val / a.wt;
            double r2 = (double) b.val / b.wt;

            return Double.compare(r2,r1);
        });

        long currWeight = 0;
        double finalVal = 0.0;

        for(Item item : items){
            if(currWeight + item.wt <= cap){
                currWeight += item.wt;
                finalVal += item.val;
            }
            else{
                long remain = cap - currWeight;

                finalVal += ((double) item.val / item.wt) * remain;
                break;
            }
        }
        return Math.round(finalVal * 1000000.0) / 1000000.0;
    }
    public static void main(String[] args) {
        int[] val = {100,60,100,200};
        int[] wt = {20,10,50,50};
        int capacity = 90;

        System.out.printf("%.6f", fractionalKnapsack(val, wt, capacity));
    }
}
