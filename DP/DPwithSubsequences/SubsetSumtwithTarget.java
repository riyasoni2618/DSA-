import java.util.*;

public class SubsetSumtwithTarget {

    // Bottom-Up DP function
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case: sum = 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                // Skip current element
                dp[i][j] = dp[i - 1][j];

                // Take current element if possible
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int sum = sc.nextInt();

        // Function call
        boolean result = isSubsetSum(arr, sum);

        // Output
        if (result) {
            System.out.println("Subset with given sum exists ✅");
        } else {
            System.out.println("Subset with given sum does NOT exist ❌");
        }

        sc.close();
    }
}