package Greedy;

import java.util.Arrays;

public class fractKnapsackGfG {

    public double knapsack(int[] val, int[] wt, int cap) {
        int n = val.length;
        double totalValue = 0.0;

        // items[i][0] = value, items[i][1] = weight, items[i][2] = value/weight ratio
        double[][] items = new double[n][3];
        for (int i = 0; i < n; i++) {
            items[i][0] = val[i];
            items[i][1] = wt[i];
            items[i][2] = val[i] / (double) wt[i];
        }
        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));

        for (int i = 0; i < n; i++) {
            if (items[i][1] <= cap) {
                totalValue += items[i][0];
                cap -= items[i][1];
            } else {
                totalValue += items[i][2] * cap;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        fractKnapsackGfG obj = new fractKnapsackGfG();

        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        double maxVal = obj.knapsack(val, wt, capacity);
        System.out.println("Maximum value in Knapsack = " + maxVal);
    }
}
