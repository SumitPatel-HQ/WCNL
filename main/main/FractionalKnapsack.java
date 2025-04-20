// Time Complexity: O(n log n) where n is the number of items
// The algorithm uses Arrays.sort() which takes O(n log n), followed by a single pass through the array O(n)
import java.util.*;

class Item {

    int weight, profit;
    double ratio;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(Item[] items, int W) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;
        double weight = 0;

        for (Item item : items) {
            if (weight + item.weight <= W) {
                totalProfit += item.profit;
                weight += item.weight;
            } else {
                totalProfit += item.ratio * (W - weight);
                break;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit of item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            int profit = sc.nextInt();
            items[i] = new Item(weight, profit);
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        double maxProfit = fractionalKnapsack(items, W);
        System.out.println("Maximum profit: " + maxProfit);

        sc.close();
    }
}