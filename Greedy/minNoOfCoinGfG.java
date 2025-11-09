package Greedy;

public class minNoOfCoinGfG {

    public static void main(String[] args) {
        int n = 23; 
        int result = findMin(n);
        System.out.println("Minimum number of coins needed: " + result);
    }

    static int findMin(int n) {
        int count = 0;
        int arr[] = {1, 2, 5, 10}; 
        for (int i = arr.length - 1; i >= 0; i--) {
            while (n >= arr[i]) {
                n -= arr[i];
                count++;
                System.out.print(arr[i] + " ");
            }
        }
        return count;
    }
}
